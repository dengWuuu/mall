package com.wu.mall.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wu.mall.entity.OrderReturnApplyEntity;
import com.wu.mall.service.OrderReturnApplyService;
import com.wu.common.utils.PageUtils;
import com.wu.common.utils.R;



/**
 * ¶©µ¥ÍË»õÉêÇë
 *
 * @author Wu
 * @email dengwu.wu@foxmail.com
 * @date 2022-08-01 17:09:20
 */
@RestController
@RequestMapping("mall/orderreturnapply")
public class OrderReturnApplyController {
    @Autowired
    private OrderReturnApplyService orderReturnApplyService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("mall:orderreturnapply:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = orderReturnApplyService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("mall:orderreturnapply:info")
    public R info(@PathVariable("id") Long id){
		OrderReturnApplyEntity orderReturnApply = orderReturnApplyService.getById(id);

        return R.ok().put("orderReturnApply", orderReturnApply);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("mall:orderreturnapply:save")
    public R save(@RequestBody OrderReturnApplyEntity orderReturnApply){
		orderReturnApplyService.save(orderReturnApply);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("mall:orderreturnapply:update")
    public R update(@RequestBody OrderReturnApplyEntity orderReturnApply){
		orderReturnApplyService.updateById(orderReturnApply);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("mall:orderreturnapply:delete")
    public R delete(@RequestBody Long[] ids){
		orderReturnApplyService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
