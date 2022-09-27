package com.wu.mall.mallsearch.controller;

import com.wu.mall.mallsearch.service.MallSearchService;
import com.wu.mall.mallsearch.vo.SearchParam;
import com.wu.mall.mallsearch.vo.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Wu
 * @date 2022年09月18日 20:18
 */
@Controller
public class SearchController {
    @Autowired
    MallSearchService mallSearchService;


    @GetMapping("/list.html")
    public String listPage(SearchParam searchParam, Model model, HttpServletRequest request) {
        searchParam.set_queryString(request.getQueryString());
        SearchResult searchResult = mallSearchService.search(searchParam);
        model.addAttribute("result", searchResult);
        return "list";
    }
}
