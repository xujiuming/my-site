package com.ming.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class MainController {

    @RequestMapping(value = {"main", "main.html"})
    public String main() {
        return "admin/main";
    }
}
