package com.wu.mall.feign;

import com.wu.common.to.es.SkuEsModel;
import com.wu.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author Wu
 * @date 2022年09月10日 19:21
 */
@FeignClient("mall-search")
public interface SearchFeignService {
    @PostMapping("/search/save/product")
    R productStatusUp(@RequestBody List<SkuEsModel> skuEsModels);
}
