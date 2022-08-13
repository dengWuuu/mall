package com.wu.mall;


import com.wu.mall.entity.BrandEntity;
import com.wu.mall.service.AttrGroupService;
import com.wu.mall.service.BrandService;
import com.wu.mall.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;


@SpringBootTest
@Slf4j
@RunWith(SpringRunner.class)
class MallProductApplicationTests {

    @Autowired
    BrandService brandService;

    @Autowired
    CategoryService categoryService;

    @Test
    void contextLoads() {
        BrandEntity entity = new BrandEntity();
        entity.setName("wdw");
        System.out.println(brandService.save(entity));
    }

    @Test
    void findPath() {
        Long[] catelogPath = categoryService.findCatelogPath(225L);
        log.debug("数组为{}", Arrays.toString(catelogPath));

    }

}
