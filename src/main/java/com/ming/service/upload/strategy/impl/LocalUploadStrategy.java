package com.ming.service.upload.strategy.impl;

import com.ming.base.config.UploadConfig;
import com.ming.service.upload.strategy.UploadStrategy;
import org.springframework.stereotype.Component;

/**
 * 本地磁盘上传策略类
 *
 * @author ming
 * @date 2024-05-06 14:04:09
 */
@Component(UploadConfig.LOCAL_UPLOAD_STRATEGY_BEAN_NAME)
public class LocalUploadStrategy implements UploadStrategy {
}
