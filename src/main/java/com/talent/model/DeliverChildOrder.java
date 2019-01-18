package com.talent.model;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author guobing
 * @Title: DeliverChildOrder
 * @ProjectName shop-manager
 * @Description: 配送员配送界面的子订单
 * @date 2019/1/18上午9:58
 */
@Setter
@Getter
public class DeliverChildOrder implements Serializable {

    private String foodName;

    private Short status;

    private Float price;

    private Float discountPrice;

    private Short isDiscount;

    private Integer orderCount;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
