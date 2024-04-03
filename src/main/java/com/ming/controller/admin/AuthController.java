package com.ming.controller.admin;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin")
@Controller
public class AuthController {

    @RequestMapping("/login")
    public String login(HttpServletRequest request) {
        request.getSession().setAttribute("user", "info");
        if (request.getMethod().equals(HttpMethod.POST.name())) {
            return "admin/index";
        }
        return "admin/login";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        return "admin/login";
    }


}
