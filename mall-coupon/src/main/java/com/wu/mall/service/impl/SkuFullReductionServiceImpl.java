package com.wu.mall.service.impl;

import com.wu.common.to.MemberPrice;
import com.wu.common.to.SkuReductionTo;
import com.wu.mall.entity.MemberPriceEntity;
import com.wu.mall.entity.SkuLadderEntity;
import com.wu.mall.service.MemberPriceService;
import com.wu.mall.service.SkuLadderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.TooManyListenersException;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wu.common.utils.PageUtils;
import com.wu.common.utils.Query;

import com.wu.mall.dao.SkuFullReductionDao;
import com.wu.mall.entity.SkuFullReductionEntity;
import com.wu.mall.service.SkuFullReductionService;


@Service("skuFullReductionService")
public class SkuFullReductionServiceImpl extends ServiceImpl<SkuFullReductionDao, SkuFullReductionEntity> implements SkuFullReductionService {

    @Autowired
    private SkuLadderService skuLadderService;

    @Autowired
    private MemberPriceService memberPriceService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SkuFullReductionEntity> page = this.page(
                new Query<SkuFullReductionEntity>().getPage(params),
                new QueryWrapper<>()
        );

        return new PageUtils(page);
    }

    @Override
    public void saveSkuReduction(SkuReductionTo skuReductionTo) {
        //保存满减打折，会员价

        //保存阶梯价格
        SkuLadderEntity skuLadderEntity = new SkuLadderEntity();
        skuLadderEntity.setSkuId(skuReductionTo.getSkuId());
        skuLadderEntity.setFullCount(skuReductionTo.getFullCount());
        skuLadderEntity.setDiscount(skuReductionTo.getDiscount());
        skuLadderEntity.setAddOther(skuReductionTo.getCountStatus());
        if (skuReductionTo.getFullCount() > 0) {
            skuLadderService.save(skuLadderEntity);
        }

        //2.保存满减信息
        SkuFullReductionEntity skuFullReductionEntity = new SkuFullReductionEntity();
        BeanUtils.copyProperties(skuReductionTo, skuFullReductionEntity);
        if (skuReductionTo.getFullPrice().compareTo(new BigDecimal(0)) > 0) {
            this.save(skuFullReductionEntity);
        }

        //3.保存会员信息
        List<MemberPrice> memberPrice = skuReductionTo.getMemberPrice();

        if (memberPrice != null) {
            List<MemberPriceEntity> collect = memberPrice
                    .stream().map(item -> {
                        MemberPriceEntity memberPriceEntity = new MemberPriceEntity();
                        memberPriceEntity.setSkuId(skuReductionTo.getSkuId());
                        memberPriceEntity.setMemberPrice(item.getPrice());
                        memberPriceEntity.setMemberLevelId(item.getId());
                        memberPriceEntity.setMemberLevelName(item.getName());
                        memberPriceEntity.setAddOther(1);
                        return memberPriceEntity;
                    })
                    .filter(item -> item.getMemberPrice().compareTo(new BigDecimal(0)) > 0)
                    .collect(Collectors.toList());
            memberPriceService.saveBatch(collect);
        }
    }

}