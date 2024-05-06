package com.ming.base.config;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "upload")
@Data
public class UploadConfig {
    // 上传策略bean名称 常量
    public static final String LOCAL_UPLOAD_STRATEGY_BEAN_NAME = "localUploadStrategy";
    public static final String MINIO_UPLOAD_STRATEGY_BEAN_NAME = "localUploadStrategy";
    private UploadType type;
    private LocalUploadConfig local;
    private OssUploadConfig oss;

    @Getter
    @AllArgsConstructor
    public enum UploadType {
        LOCAL(LOCAL_UPLOAD_STRATEGY_BEAN_NAME),
        MINIO(MINIO_UPLOAD_STRATEGY_BEAN_NAME);

        private String strategyBeanName;

    }

    @Data
    public static class LocalUploadConfig {
        private String path;
    }

    @Data
    public static class OssUploadConfig {
    }
}
