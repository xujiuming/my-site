package com.ming.service.upload;

import com.ming.base.config.UploadConfig;
import com.ming.core.dto.UploadResultDTO;
import com.ming.service.upload.strategy.UploadStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Service
public class UploadService {

    @Autowired
    public Map<String, UploadStrategy> uploadStrategyMap;
    @Autowired
    private UploadConfig uploadConfig;

    private UploadStrategy getStrategy() {
        if (!uploadStrategyMap.containsKey(uploadConfig.getType().getStrategyBeanName())) {
            throw new RuntimeException("获取" + uploadConfig.getType().name() + "类型上传策略失败!");
        }
        return uploadStrategyMap.get(uploadConfig.getType().getStrategyBeanName());
    }

    public UploadResultDTO upload(MultipartFile file) {
        return null;
    }

    public UploadResultDTO findById(Long id) {
        return null;
    }


    public String getDownloadUrl(Long id) {
        return null;
    }

    public Boolean deleteById(Long id) {
        return null;
    }
}
