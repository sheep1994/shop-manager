package com.talent.model;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author guobing
 * @Title: DeliverOrder
 * @ProjectName shop-manager
 * @Description: 配送员配送界面实体类
 * @date 2019/1/18上午9:57
 */
@Setter
@Getter
public class DeliverOrder implements Serializable {

    private String togetherId;

    private String nickName;

    private Short status;

    private Float totalPrice;

    /**
     * 配送地址
     */
    private String address;

    private String customePhone;

    private Date togetherDate;

    private String reserveTime;

    private String message;

    private String adminName;

    private List<DeliverChildOrder> orderList;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
