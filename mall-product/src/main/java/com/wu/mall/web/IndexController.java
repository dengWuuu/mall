package com.wu.mall.web;

import com.wu.mall.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Wu
 * @date 2022年09月10日 21:23
 */
@Controller
public class IndexController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping({"/", "index.html"})
    public String indexPage() {
        //TODO 查出分类信息
        return "index";
    }
}
