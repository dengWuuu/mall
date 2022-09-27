package com.wu.mall.vo;

import com.wu.mall.vo.save.Attr;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@ToString
@Data
public class SpuItemAttrGroupVo {

    private String groupName;
    private List<Attr> attrs;
}
