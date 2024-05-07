package com.ming.service.upload.strategy;


import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public interface UploadStrategy {

    UploadResultDTO upload(String fileName, byte[] fileBytes) throws IOException;

    UploadResultDTO upload(String fileName, InputStream is) throws IOException;

    String buildAccessUrl(BuildUrlDTO buildUrlDTO);
    /**
     * 构建path
     * 默认规则 就是 yyyy/MM/dd/originFileName
     *
     * @author ming
     * @date 2024-05-06 14:32:15
     */
    default String buildPath(String originFileName) {
        if (originFileName.startsWith("/")) {
            return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd/HHmmssSSS")) + originFileName;
        } else {
            return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd/HHmmssSSS/")) + originFileName;
        }
    }


    String getPrefixPath();
}
