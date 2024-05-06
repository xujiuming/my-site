package com.ming.core.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.CRC32;

/**
 * crc32算法 完整性校验
 *
 * @author ming
 * @date 2024-05-06 11:18:48
 */
public class Crc32Utils {
    private static final CRC32 CRC = new CRC32();

    private Crc32Utils() {
    }

    /**
     * 计算输入流的crc值。
     * 默认缓冲区 8192
     *
     * @param inputStream 数据输入流
     * @return 计算得到的crc值
     * @throws IOException 流操作过程中可能发生的异常
     */
    public static long check(InputStream inputStream) throws IOException {
        return check(inputStream, 8192);
    }

    /**
     * 计算输入流的crc值。
     *
     * @param inputStream 数据输入流
     * @param bufferSize  缓冲区大小
     * @return 计算得到的crc值
     * @throws IOException 流操作过程中可能发生的异常
     * @author ming
     * @date 2024-05-06 11:34:03
     */
    public static long check(InputStream inputStream, int bufferSize) throws IOException {
        CRC.reset();
        // 缓冲区大小可以根据实际情况调整
        byte[] buffer = new byte[bufferSize];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            CRC.update(buffer, 0, bytesRead);
        }
        return CRC.getValue();
    }

    /**
     * 计算字节数组的crc值。
     *
     * @param data 字节数组
     * @return 计算得到的crc值
     */
    public static long check(byte[] data) {
        CRC.reset();
        CRC.update(data, 0, data.length);
        return CRC.getValue();
    }
}
