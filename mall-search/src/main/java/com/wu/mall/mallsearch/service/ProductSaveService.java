package com.wu.mall.mallsearch.service;

import com.wu.common.to.es.SkuEsModel;

import java.util.List;

/**
 * @author Wu
 * @date 2022年09月09日 21:24
 */
public interface ProductSaveService {
    boolean productStatusUp(List<SkuEsModel> skuEsModels);
}
