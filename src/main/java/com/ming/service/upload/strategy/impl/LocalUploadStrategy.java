package com.ming.service.upload.strategy.impl;

import com.google.common.base.Preconditions;
import com.ming.base.config.UploadConfig;
import com.ming.core.utils.FileTypeUtils;
import com.ming.core.utils.SignatureUtils;
import com.ming.service.upload.strategy.UploadResultDTO;
import com.ming.service.upload.strategy.UploadStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * 本地磁盘上传策略类
 *
 * @author ming
 * @date 2024-05-06 14:04:09
 */
@Component(UploadConfig.LOCAL_UPLOAD_STRATEGY_BEAN_NAME)
public class LocalUploadStrategy implements UploadStrategy {
    @Autowired
    private UploadConfig uploadConfig;

    private UploadConfig.LocalUploadConfig getConfig() {
        UploadConfig.LocalUploadConfig config = uploadConfig.getLocal();
        Preconditions.checkNotNull(config, "local类型上传策略,配置不能为null");
        Preconditions.checkNotNull(config.getPath(), "local类型上传策略,存储路径配置不能为null");
        return config;
    }

    @Override
    public UploadResultDTO upload(String fileName, byte[] fileBytes) throws IOException {
        return upload(fileName, new ByteArrayInputStream(fileBytes));
    }

    @Override
    public UploadResultDTO upload(String fileName, InputStream is) throws IOException {
        String path = buildPath(fileName);
        Path localPath = Path.of(getConfig().getPath() + path);
        Files.createDirectories(localPath.getParent());
        long size = Files.copy(is, localPath, StandardCopyOption.REPLACE_EXISTING);
        UploadResultDTO resultDTO = new UploadResultDTO();
        resultDTO.setName(fileName);
        resultDTO.setPath(path);
        resultDTO.setType(FileTypeUtils.getFileType(localPath.toString()).orElse(FileTypeUtils.FileType.OTHER));
        resultDTO.setCheckCode(SignatureUtils.md5ToHex(new FileInputStream(new File(localPath.toUri()))));
        resultDTO.setSize(size);
        return resultDTO;
    }
}
