package com.talent.model;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author guobing
 * @Title: Order
 * @ProjectName shop-manager
 * @Description: 订单实体类
 * @date 2019/1/18上午9:37
 */
@Setter
@Getter
public class Order implements Serializable {

    private Long orderId;

    private Integer campusId;

    private String phone;

    private Date createTime;

    private Short status;

    private Float price;

    private Integer orderCount;

    private Short isRemarked;

    private Short tag;

    private Long foodId;

    private String togetherId;

    private String rank;

    private Short payWay;

    private Float totalPrice;

    public Order(){

    }

    public Order(Integer campusId,String phoneId, Long foodId2, Integer foodCount) {
        this.setCampusId(campusId);
        this.phone = phoneId;
        foodId = foodId2;
        orderCount = foodCount;
        tag = 1;
        createTime = new Date();
        status = 0;
        isRemarked = 0;
        orderId = createTime.getTime();
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
