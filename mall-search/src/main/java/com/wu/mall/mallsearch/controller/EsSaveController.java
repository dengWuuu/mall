package com.wu.mall.mallsearch.controller;

import com.wu.common.exception.BizCodeEnume;
import com.wu.common.to.es.SkuEsModel;
import com.wu.common.utils.R;
import com.wu.mall.mallsearch.service.ProductSaveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Wu
 * @date 2022年09月09日 21:22
 */
@RequestMapping("/search/save")
@RestController
@Slf4j
public class EsSaveController {
    @Autowired
    private ProductSaveService productSaveService;

    @PostMapping("/product")
    public R productStatusUp(@RequestBody List<SkuEsModel> skuEsModels) {
        boolean b = productSaveService.productStatusUp(skuEsModels);
        if (!b) {
            log.error("商品上架错误，EsSaveController");
            return R.error(BizCodeEnume.PRODUCT_UP_EXCEPTION.getCode(), BizCodeEnume.PRODUCT_UP_EXCEPTION.getMsg());
        }
        return R.ok();
    }
}
