package com.ming.core.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileUtils {


    public static boolean createFile(Path path) throws IOException {
        // 获取文件的父目录路径
        Path parentDirPath = path.getParent();
        // 如果父目录不存在，则创建之
        if (parentDirPath != null) {
            Files.createDirectories(parentDirPath);
        }

        // 创建文件
        if (Files.notExists(path)) {
            Files.createFile(path);
            return true;
        } else {
            return false;
        }
    }
}
