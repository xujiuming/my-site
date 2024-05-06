package com.ming.controller.admin;

import com.ming.Entity.ArticleEntity;
import com.ming.base.BaseController;
import com.ming.core.dto.JsonResult;
import com.ming.core.orm.SpecificationUtils;
import com.ming.core.query.ArticleQuery;
import com.ming.service.entity.ArticleEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/article")
@RequiredArgsConstructor
public class ArticleController extends BaseController {

    private final ArticleEntityService articleEntityService;

    @GetMapping("main")
    public String main(Model model, ArticleQuery query) {
        model.addAttribute("pageData", articleEntityService.page(SpecificationUtils.build(query), pageable()));
        return "/admin/comment/article/main";
    }

    @PostMapping("save")
    @ResponseBody
    public JsonResult<ArticleEntity> save(@RequestBody ArticleEntity entity) {
        return JsonResult.ok(articleEntityService.saveAndFlush(entity));
    }

    @DeleteMapping("delete")
    @ResponseBody
    public JsonResult<Boolean> delete(Long id) {
        return JsonResult.ok(articleEntityService.deleteById(id));
    }
}
