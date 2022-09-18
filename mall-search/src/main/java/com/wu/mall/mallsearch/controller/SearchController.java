package com.wu.mall.mallsearch.controller;

import com.wu.mall.mallsearch.service.MallSearchService;
import com.wu.mall.mallsearch.vo.SearchParam;
import com.wu.mall.mallsearch.vo.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Wu
 * @date 2022年09月18日 20:18
 */
@Controller
public class SearchController {
    @Autowired
    MallSearchService mallSearchService;


    @GetMapping("/list.html")
    public String listPage(SearchParam searchParam) {
        SearchResult searchResult = mallSearchService.search(searchParam);
        return "list";
    }
}
