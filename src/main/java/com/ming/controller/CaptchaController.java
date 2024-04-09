package com.ming.controller;

import com.ming.core.dto.JsonResult;
import com.ming.service.CaptchaService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.io.OutputStream;

@RequestMapping("/captcha")
@RequiredArgsConstructor
@Controller
public class CaptchaController {
    private final CaptchaService captchaService;

    @GetMapping("/generator")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        OutputStream os = response.getOutputStream();
        os.write(captchaService.generateCaptcha(request.getSession().getId()));
        os.flush();
        os.close();
    }

    @PostMapping("/verify")
    public JsonResult<String> verifyCaptcha(HttpServletRequest request, String captcha) {
        return captchaService.verifyCaptcha(request.getSession().getId(), captcha) ? JsonResult.ok("验证成功") : JsonResult.error(403, "验证码错误");
    }
}
