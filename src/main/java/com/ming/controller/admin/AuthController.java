package com.ming.controller.admin;

import com.ming.core.dto.JsonResult;
import com.ming.core.dto.UserInfoDTO;
import com.ming.core.dto.request.LoginAuthRequest;
import com.ming.service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/admin")
@Controller
@RequiredArgsConstructor
public class AuthController {
    private final LoginService loginService;

    @GetMapping("/login")
    public String login(HttpServletRequest request) {
        return "admin/login";
    }

    @PostMapping("/login")
    @ResponseBody
    public JsonResult<UserInfoDTO> loginAuth(LoginAuthRequest request) {
        return loginService.login(request);
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        return "admin/login";
    }

    @RequestMapping(value = {"/index", "/index.html"})
    public String index() {
        return "admin/index";
    }

}
