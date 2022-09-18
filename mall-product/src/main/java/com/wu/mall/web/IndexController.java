package com.wu.mall.web;

import com.wu.mall.entity.CategoryEntity;
import com.wu.mall.service.CategoryService;
import com.wu.mall.vo.Catelog2Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author Wu
 * @date 2022年09月10日 21:23
 */
@Controller
public class IndexController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping({"/", "/index.html"})
    public String indexPage(Model model) {
        //TODO 1、查出所有的1级分类
        List<CategoryEntity> categoryEntities = categoryService.getLevelOneCategories();
        // 视图解析器进行拼串：
        // classpath:/templates/ +返回值+  .html
        model.addAttribute("categorys", categoryEntities);
        return "index";
    }

    @ResponseBody
    @GetMapping("/index/catalog.json")
    public Map<String, List<Catelog2Vo>> getCatalogJson(){
        return categoryService.getCatalogJson();
    }
}
