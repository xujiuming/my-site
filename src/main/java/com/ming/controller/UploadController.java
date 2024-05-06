package com.ming.controller;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 上传服务
 * 所有上传需要登陆  走服务端代理  内部实现多策略  如 local  oss  minio 等策略
 *
 * @author ming
 * @date 2024-05-06 10:16:29
 */
@RequestMapping("/upload")
public class UploadController {
}
