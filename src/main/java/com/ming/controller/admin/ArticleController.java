package com.ming.controller.admin;

import com.ming.base.BaseController;
import com.ming.service.entity.ArticleEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/article")
@RequiredArgsConstructor
public class ArticleController implements BaseController {

    private final ArticleEntityService articleEntityService;

    @GetMapping("main")
    public String main(Model model) {
        model.addAttribute("pageData", articleEntityService.page(pageable(0, 10)));
        return "admin/comment/article/main";
    }
}
