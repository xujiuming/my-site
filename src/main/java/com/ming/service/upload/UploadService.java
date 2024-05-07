package com.ming.service.upload;

import com.ming.Entity.UploadInfoEntity;
import com.ming.base.config.UploadConfig;
import com.ming.service.entity.UploadInfoEntityService;
import com.ming.service.upload.strategy.UploadResultDTO;
import com.ming.service.upload.strategy.UploadStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
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

    public String buildAccessUrl(Long id) {
        return null;
    }

    public ResponseEntity<FileSystemResource> download(Long id) throws IOException {
        UploadInfoEntity uploadInfoEntity = uploadInfoEntityService.findById(id).orElseThrow();

        // 构造文件路径，注意这里的路径是相对于类路径的
        File file = new ClassPathResource(getStrategy().getPrefixPath() + uploadInfoEntity.getName()).getFile();

        // 检查文件是否存在
        if (!file.exists()) {
            return ResponseEntity.notFound().build();
        }

        // 设置响应头，指示浏览器这是一个文件下载
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + uploadInfoEntity.getOriginalName() + "\"");
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        // 使用FileSystemResource包装文件，然后用ResponseEntity返回
        FileSystemResource resource = new FileSystemResource(file);
        return ResponseEntity.ok()
                .headers(headers)
                .body(resource);
    }
}
