package com.ming.controller.admin;

import com.ming.core.dto.JsonResult;
import com.ming.core.dto.UserInfoDTO;
import com.ming.core.dto.request.LoginAuthRequest;
import com.ming.service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/admin")
@Controller
@RequiredArgsConstructor
public class AuthController {
    private final LoginService loginService;

    @GetMapping("/login")
    public String login(HttpServletRequest request, @RequestParam String errorAuthMsg) {
        if (StringUtils.isNotBlank(errorAuthMsg)) {
            request.setAttribute("errorAuthMsg", "授权失效!已退出系统,请重新登录");
        }
        return "admin/login";
    }

    @PostMapping("/login")
    @ResponseBody
    public JsonResult<UserInfoDTO> loginAuth(HttpServletRequest httpServletRequest, LoginAuthRequest request) {
        return loginService.login(httpServletRequest, request);
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
