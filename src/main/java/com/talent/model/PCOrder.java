package com.talent.model;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author guobing
 * @Title: PCOrder
 * @ProjectName shop-manager
 * @Description: web管理单显示订单
 * @date 2019/1/18上午9:59
 */
@Setter
@Getter
public class PCOrder implements Serializable {

    private String togetherId;

    private String phone;

    /**
     * 食品名称
     */
    private String name;

    /**
     * 食品总价格
     */
    private Float price;

    private String adminName;

    private Integer orderCount;

    /**
     * 配送地址
     */
    private String address;

    private Short isDiscount;

    /**
     * 折扣价
     */
    private Float discountPrice;

    private Float foodPrice;

    /**
     * 收货人手机号
     */
    private String receiverPhone;

    private Date togetherDate;

    /**
     * 配送人手机号
     */
    private String adminPhone;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
