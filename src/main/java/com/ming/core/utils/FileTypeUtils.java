package com.ming.core.utils;

import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;
import java.util.Set;

/**
 * 文件类型工具类
 * 根据后缀判断文件类型并不是很准确
 * 需要根据文件的头四位来获取文件真实类型
 * <p>
 * 新增文件类型操作方式:
 * 1:修改main函数里面的文件地址 并且执行获取headerHex
 * 2:FileType枚举新增枚举
 * <p>
 * <a href="http://doc.chacuo.net/filehead">常见文件参考headerHex</a>
 *
 * @author ming
 * @date 2022-01-04 18:37:33
 */
public class FileTypeUtils {

    /**
     * 头部字节数组长度
     */
    private static final int HEADER_BYTE_ARRAY_LENGTH = 4;

    private FileTypeUtils() {
    }

    /**
     * 获取常见文件的文件头
     *
     * @author ming
     * @date 2022-04-18 10:29:41
     */
    public static void main(String[] args) throws IOException {
        String path = "";
        System.out.println(getFileHeaderHex(Files.newInputStream(Path.of(path))));
    }


    /**
     * 根据文件路径获取文件格式信息
     *
     * @param filePath 文件路径
     * @return String 文件类型
     * @author ming
     * @date 2022-04-18 11:54:41
     */
    public static Optional<FileType> getFileType(String filePath) throws IOException {
        return getFileType(Files.newInputStream(Path.of(filePath)));
    }


    /**
     * 根据文件InputStream获取文件格式信息
     *
     * @param fileInputStream 文件输入流
     * @return String 文件类型
     * @author ming
     * @date 2022-04-18 11:54:41
     */
    public static Optional<FileType> getFileType(InputStream fileInputStream) throws IOException {
        return getFileTypeByFileHeaderHex(getFileHeaderHex(fileInputStream));
    }

    /**
     * 根据文件内容byte数组获取文件格式信息
     *
     * @param fileBytes 文件内容数组
     * @return String 文件类型
     * @author ming
     * @date 2022-04-18 11:54:41
     */
    public static Optional<FileType> getFileType(byte[] fileBytes) {
        return getFileTypeByFileHeaderHex(getFileHeaderHex(fileBytes));
    }


    /**
     * 根据文件headerHex 返回文件类型
     *
     * @param fileHeaderHex 文件头部hex
     * @return String 文件类型
     * @author ming
     * @date 2022-04-18 11:55:56
     */
    private static Optional<FileType> getFileTypeByFileHeaderHex(String fileHeaderHex) {
        assert StringUtils.isNotEmpty(fileHeaderHex);
        return Arrays.stream(FileType.values())
                .filter(f -> f.headerHexSet.contains(fileHeaderHex))
                .findAny();
    }

    /**
     * byte数组转换成16进制字符串
     *
     * @param src 字节数组
     * @return String  大写的hex码
     */
    private static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder();
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            // 以十六进制（基数 16）无符号整数形式返回一个整数参数的字符串表示形式，并转换为大写
            String hv = Integer.toHexString(src[i] & 0xFF).toUpperCase();
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    /**
     * 根据文件数组 获取文件头部Hex码
     *
     * @param fileBytes 文件内容数组
     * @return String fileHeaderHex
     * @author ming
     * @date 2022-04-18 11:44:50
     */
    private static String getFileHeaderHex(byte[] fileBytes) {
        if (fileBytes.length <= HEADER_BYTE_ARRAY_LENGTH) {
            throw new RuntimeException("字节数组长度不能小于等于" + HEADER_BYTE_ARRAY_LENGTH);
        }
        byte[] headerBytes = new byte[HEADER_BYTE_ARRAY_LENGTH];
        //获取前四个字节
        System.arraycopy(fileBytes, 0, headerBytes, 0, HEADER_BYTE_ARRAY_LENGTH);
        return bytesToHexString(headerBytes);
    }

    /**
     * 根据文件流获取文件头部hex码
     * <p>
     * 会执行InputStream#close()
     *
     * @param inputStream 输入流
     * @return String fileHeaderHex
     * @throws IOException
     * @author ming
     * @date 2022-04-18 11:48:08
     */
    private static String getFileHeaderHex(InputStream inputStream) throws IOException {
        try {
            byte[] b = new byte[HEADER_BYTE_ARRAY_LENGTH];
            inputStream.read(b, 0, b.length);
            return bytesToHexString(b);
        } finally {
            inputStream.close();
        }
    }


    @Getter
    @AllArgsConstructor
    public enum FileType {
        JPG(Sets.newHashSet("FFD8FFE0", "FFD8FFE000104A4649460001", "FFD8FFEE"), Sets.newHashSet(".jpg", "jpeg"), "JPEG原始或JFIF或Exif文件格式"),
        PNG(Sets.newHashSet("89504E47"), Sets.newHashSet(".png"), "png格式图片,以可移植网络图形格式编码的图像"),
        JAVA_FILE(Sets.newHashSet("7061636B"), Sets.newHashSet(".java"), "java源码文件"),
        JAVA_CLASS_FILE(Sets.newHashSet("CAFEBABE"), Sets.newHashSet(".class"), "java字节码文件"),
        OTHER(Sets.newHashSet(), Sets.newHashSet(), "未识别类型");
        private Set<String> headerHexSet;
        private Set<String> suffixSet;
        private String desc;
    }

}