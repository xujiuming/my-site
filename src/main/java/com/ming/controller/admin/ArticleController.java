package com.ming.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/article")
public class ArticleController {

    @GetMapping("main")
    public String main() {
        return "admin/comment/article/main";
    }
}
