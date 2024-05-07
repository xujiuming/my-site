package com.ming.service.upload;

import com.ming.Entity.UploadInfoEntity;
import com.ming.base.config.UploadConfig;
import com.ming.service.entity.UploadInfoEntityService;
import com.ming.service.upload.strategy.UploadResultDTO;
import com.ming.service.upload.strategy.UploadStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class UploadService {

    @Autowired
    public Map<String, UploadStrategy> uploadStrategyMap;
    @Autowired
    private UploadConfig uploadConfig;
    @Autowired
    private UploadInfoEntityService uploadInfoEntityService;

    private UploadStrategy getStrategy() {
        if (!uploadStrategyMap.containsKey(uploadConfig.getType().getStrategyBeanName())) {
            throw new RuntimeException("获取" + uploadConfig.getType().name() + "类型上传策略失败!");
        }
        return uploadStrategyMap.get(uploadConfig.getType().getStrategyBeanName());
    }

    public UploadInfoEntity upload(MultipartFile file) throws IOException {
        UploadResultDTO resultDTO = getStrategy().upload(file.getOriginalFilename(), file.getInputStream());
        UploadInfoEntity entity = new UploadInfoEntity();
        entity.setName(resultDTO.getName());
        entity.setOriginalName(resultDTO.getName());
        entity.setUrl(resultDTO.getPath());
        entity.setCheckCode(resultDTO.getCheckCode());
        entity.setSize(resultDTO.getSize());
        entity.setFileType(resultDTO.getType().name());
        entity.setUploadType(uploadConfig.getType().name());
        return uploadInfoEntityService.saveAndFlush(entity);
    }

    public UploadInfoEntity findById(Long id) {
        return null;
    }


    public String getDownloadUrl(Long id) {
        return null;
    }

    public Boolean deleteById(Long id) {
        return null;
    }
}
