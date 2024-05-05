package com.ming.service;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.ming.core.utils.GeneratorCaptchaUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 验证码服务  本地实现模式
 *
 * @author ming
 * @date 2024-04-09 19:45:03
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class CaptchaService  {
    private static final Random RAND = new Random();
    private static final Cache<String, String> CAPTCHA_CACHE = CacheBuilder.newBuilder()
            //写入30分钟丢弃
            .expireAfterWrite(30, TimeUnit.MINUTES)
            .build();


    public byte[] generateCaptcha(String key) throws IOException {
        String random = String.valueOf(RAND.nextInt(1000, 9999));
        CAPTCHA_CACHE.put(key, random);
        return GeneratorCaptchaUtils.generateCaptcha(random);
    }


    public boolean verifyCaptcha(String key, String captcha) {
        String oldCaptcha = CAPTCHA_CACHE.getIfPresent(key);
        if (StringUtils.isNotBlank(oldCaptcha)) {
            if (captcha.equals(oldCaptcha)) {
                CAPTCHA_CACHE.invalidate(key);
                return true;
            }
        }
        return false;
    }


    public void clearCaptcha(String key) {
        CAPTCHA_CACHE.invalidate(key);
    }
}
