package com.ming.controller;

import com.ming.Entity.UploadInfoEntity;
import com.ming.core.dto.JsonResult;
import com.ming.service.upload.UploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 上传服务
 * 所有上传需要登陆  走服务端代理  内部实现多策略  如 local  oss  minio 等策略
 *
 * @author ming
 * @date 2024-05-06 10:16:29
 */
@Controller
@RequestMapping("/open/upload")
@RequiredArgsConstructor
public class UploadController {

    private final UploadService uploadService;

    @PostMapping
    public UploadInfoEntity upload(@RequestParam("file") MultipartFile file) throws IOException {
        if (file == null || file.isEmpty()) {
            throw new RuntimeException("上传文件不能为空");
        }
        return uploadService.upload(file);
    }

    @GetMapping("/{id}")
    public JsonResult<UploadInfoEntity> get(@PathVariable("id") Long id) {
        return JsonResult.ok(uploadService.findById(id));
    }


    @DeleteMapping("/{id}")
    public JsonResult<Boolean> delete(@PathVariable("id") Long id) {
        return JsonResult.ok(uploadService.deleteById(id));
    }

}
