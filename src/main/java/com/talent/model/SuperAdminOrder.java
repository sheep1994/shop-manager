package com.talent.model;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author guobing
 * @Title: SuperAdminOrder
 * @ProjectName shop-manager
 * @Description: 超级管理员管理派单实体类
 * @date 2019/1/18上午9:55
 */
@Setter
@Getter
public class SuperAdminOrder implements Serializable {

    private String togetherId;

    private Date togetherDate;

    private String address;

    private String userPhone;

    private Integer orderCount;

    private String adminPhone;

    private String adminName;

    private Float price;

    private String reserveTime;

    private String message;

    private String chargeId;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
