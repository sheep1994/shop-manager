package com.talent.model;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author guobing
 * @Title: CartGood
 * @ProjectName shop-manager
 * @Description: 购物车实体类
 * @date 2019/1/18上午9:52
 */
@Getter
@Setter
public class CartGood implements Serializable {

    private Long orderId;

    private String name;

    private String phone;

    private Short status;

    private Float price;

    private Float discountPrice;

    private Short isDiscount;

    private Integer orderCount;

    private Short tag;

    private Short isFullDiscount;


    private Long foodId;

    private String  imageUrl;


    private Integer foodCount;

    private String message;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
