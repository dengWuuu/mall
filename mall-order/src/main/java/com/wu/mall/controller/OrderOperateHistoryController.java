package com.wu.mall.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wu.mall.entity.OrderOperateHistoryEntity;
import com.wu.mall.service.OrderOperateHistoryService;
import com.wu.common.utils.PageUtils;
import com.wu.common.utils.R;



/**
 * ¶©µ¥²Ù×÷ÀúÊ·¼ÇÂ¼
 *
 * @author Wu
 * @email dengwu.wu@foxmail.com
 * @date 2022-08-01 17:09:20
 */
@RestController
@RequestMapping("mall/orderoperatehistory")
public class OrderOperateHistoryController {
    @Autowired
    private OrderOperateHistoryService orderOperateHistoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("mall:orderoperatehistory:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = orderOperateHistoryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("mall:orderoperatehistory:info")
    public R info(@PathVariable("id") Long id){
		OrderOperateHistoryEntity orderOperateHistory = orderOperateHistoryService.getById(id);

        return R.ok().put("orderOperateHistory", orderOperateHistory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("mall:orderoperatehistory:save")
    public R save(@RequestBody OrderOperateHistoryEntity orderOperateHistory){
		orderOperateHistoryService.save(orderOperateHistory);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("mall:orderoperatehistory:update")
    public R update(@RequestBody OrderOperateHistoryEntity orderOperateHistory){
		orderOperateHistoryService.updateById(orderOperateHistory);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("mall:orderoperatehistory:delete")
    public R delete(@RequestBody Long[] ids){
		orderOperateHistoryService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
