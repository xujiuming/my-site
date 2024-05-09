package com.ming.controller;

import com.ming.base.BaseController;
import com.ming.service.entity.ArticleEntityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class IndexController extends BaseController {
    @Autowired
    private ArticleEntityService articleEntityService;
    @RequestMapping(value = {"", "/", "index", "/index.html", "/index.htm"})
    public String index(Model model) {
        Pageable pageable =  pageable();
        pageable.getSortOr(Sort.by(Sort.Direction.DESC,"last_update_time"));
        model.addAttribute("articlePage",articleEntityService.page(pageable));
        return "index";
    }
}
