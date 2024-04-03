package com.ming.controller.admin;

import com.ming.core.dto.JsonResult;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/admin")
@Controller
public class AuthController {

    @GetMapping("/login")
    public String login(HttpServletRequest request) {
        return "admin/login";
    }

    @PostMapping("/login")
    @ResponseBody
    public JsonResult<String> login1(HttpServletRequest request) {
        if ("ming".equals(request.getParameter("username"))) {
            return JsonResult.ok("登录成功");
        }
        return JsonResult.error(403, "用户名或密码错误");
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
