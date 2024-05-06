package com.ming.core.dto;

import lombok.Data;

@Data
public class UploadResultDTO {
    private Long id;
    /**
     * 文件名
     * 会根据不同策略实现  返回不同的名字 此名字为文件服务中的文件名
     */
    private String name;
    /***
     * 文件路径
     * 会根据不同策略实现 返回不同
     * 如local会返回当前存储路径下的相对路径
     * oss返回objectKey
     * */
    private String path;
    /**
     * 返回文件类型
     * <p>
     * 内部根据文件头判断  实现结果 依赖文件头的配置是否齐全
     * {@link com.ming.core.utils.FileTypeUtils}
     */
    private String type;
    /**
     * 校验码
     */
    private String checkCode;
    /**
     * 文件大小
     */
    private Long size;
    /**
     * 文件下载地址
     * local-需要认证校验
     * oss-需要签名cdn
     */
    private String downloadUrl;
}
