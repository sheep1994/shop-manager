package com.talent.model;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author guobing
 * @Title: SmallOrder
 * @ProjectName shop-manager
 * @Description: 用户订单实体类
 * @date 2019/1/18上午9:53
 */
@Setter
@Getter
public class SmallOrder implements Serializable {

    private Long foodId;
    private Integer campusId;

    private Long orderId;

    private String togetherId;

    private String name;

    private Short status;

    private Float price;

    private Float discountPrice;

    private Short isDiscount;

    private Integer orderCount;

    /**
     * 配送地址
     */
    private String address;

    /**
     * 配送员号码
     */
    private String adminPhone;

    private String  imageUrl;

    private String specialName;

    private Integer foodCount;

    private Short isRemarked;

    private String rank;

    private Date togetherDate;

    private String message;

    private Short payWay;

    private Float totalPrice;

    private Short isFullDiscount;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
