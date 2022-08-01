package com.wu.mall;

import com.wu.mall.entity.BrandEntity;
import com.wu.mall.service.BrandService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class MallProductApplicationTests {

    @Autowired
    BrandService brandService;

    @Test
    void contextLoads() {
        BrandEntity entity = new BrandEntity();
        entity.setName("wdw");
        System.out.println(brandService.save(entity));
    }

}
