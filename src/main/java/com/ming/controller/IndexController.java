package com.ming.controller;

import com.ming.base.BaseController;
import com.ming.service.entity.ArticleEntityService;
import com.ming.service.entity.CategoryEntityService;
import com.ming.service.entity.TagEntityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class IndexController extends BaseController {
    @Autowired
    private ArticleEntityService articleEntityService;
    @Autowired
    private CategoryEntityService categoryEntityService;
    @Autowired
    private TagEntityService tagEntityService;

    @RequestMapping(value = {"", "/", "index", "/index.html", "/index.htm"})
    public String index(Model model) {
        model.addAttribute("articlePage", articleEntityService.page(pageable(Sort.by(Sort.Direction.DESC, "lastUpdateTime"))));
        model.addAttribute("categoryDtoList", categoryEntityService.findCategoryIndexDTO());
        model.addAttribute("tagDtoList", tagEntityService.findTagIndexDTO());
        return "index";
    }

    @RequestMapping("/ming/{link}")
    public String details(@PathVariable String link, Model model) {
        model.addAttribute("article", articleEntityService.findOneByLink(link.replace(".html", "")).orElseThrow());
        return "details";
    }
}
