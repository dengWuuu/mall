package com.wu.mall.mallsearch.service;

import com.wu.mall.mallsearch.vo.SearchParam;
import com.wu.mall.mallsearch.vo.SearchResult;

/**
 * @author Wu
 * @date 2022年09月18日 20:39
 */
public interface MallSearchService {
    /**
     *
     * @param searchParam 检索参数
     * @return 检索结果
     */
    SearchResult search(SearchParam searchParam);
}
