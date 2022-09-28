package com.wu.mall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wu.common.utils.PageUtils;
import com.wu.mall.entity.MemberEntity;
import com.wu.mall.exception.PhoneExsitException;
import com.wu.mall.exception.UsernameExistException;
import com.wu.mall.vo.MemberLoginVo;
import com.wu.mall.vo.MemberRegistVo;
import com.wu.mall.vo.SocialUser;

import java.util.Map;

/**
 * ??Ա
 *
 * @author Wu
 * @email dengwu.wu@foxmail.com
 * @date 2022-08-01 17:02:59
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void regist(MemberRegistVo vo);

    void checkPhoneUnique(String phone) throws PhoneExsitException;

    void checkUsernameUnique(String username) throws UsernameExistException;

    MemberEntity login(MemberLoginVo vo);

    MemberEntity login(SocialUser socialUser);
}

