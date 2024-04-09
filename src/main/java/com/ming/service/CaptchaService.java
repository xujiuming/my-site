package com.ming.service;

import java.io.IOException;

public interface CaptchaService {
    /**
     * 根据唯一key生成验证码图片流
     *
     * @param key 唯一key
     * @author ming
     * @date 2024-04-09 19:54:54
     */
    byte[] generateCaptcha(String key) throws IOException;

    /**
     * 根据唯一key 和前端上传的captcha值 验证
     *
     * @param key     唯一key
     * @param captcha 前端上传的captcha值
     * @author ming
     * @date 2024-04-09 19:55:16
     */
    boolean verifyCaptcha(String key, String captcha);

    /**
     * 根据唯一key清除验证码
     *
     * @param key 唯一key
     * @author ming
     * @date 2024-04-09 19:55:27
     */
    void clearCaptcha(String key);
}
