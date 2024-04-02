package com.ming.controller.admin;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin")
@Controller
public class AuthController {

    @RequestMapping("/login")
    public String login(HttpServletRequest request) {
        request.getSession().setAttribute("user","info");
        return "admin/login";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        return "admin/login";
    }



}
