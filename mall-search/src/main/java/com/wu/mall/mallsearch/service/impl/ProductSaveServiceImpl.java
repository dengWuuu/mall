package com.wu.mall.mallsearch.service.impl;

import com.alibaba.fastjson2.JSON;
import com.wu.common.to.es.SkuEsModel;
import com.wu.mall.mallsearch.config.ElasticSearchConfig;
import com.wu.mall.mallsearch.constant.EsConstant;
import com.wu.mall.mallsearch.service.ProductSaveService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.bulk.BulkItemResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Wu
 * @date 2022年09月09日 21:25
 */
@Service
@Slf4j
public class ProductSaveServiceImpl implements ProductSaveService {
    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Override
    public boolean productStatusUp(List<SkuEsModel> skuEsModels) {
        //保存数据到es
        //1. 建立索引

        //2. 保存数据
        BulkRequest bulkRequest = new BulkRequest();
        for (SkuEsModel skuEsModel : skuEsModels) {
            IndexRequest request = new IndexRequest(EsConstant.PRODUCT_INDEX);
            request.id(skuEsModel.getSkuId().toString());
            request.source(JSON.toJSONString(skuEsModel), XContentType.JSON);
            bulkRequest.add(request);
        }
        BulkResponse bulk = null;
        try {
            bulk = restHighLevelClient.bulk(bulkRequest, ElasticSearchConfig.COMMON_OPTIONS);
        } catch (Exception e) {
            log.error("es bulk请求失败");
        }
        boolean b = bulk.hasFailures();
        BulkItemResponse[] items = bulk.getItems();
        List<String> collect = Arrays.stream(items).map(BulkItemResponse::getId).collect(Collectors.toList());
        log.info("商品上架成功：商品：{}", collect);
        return !b;
    }
}
