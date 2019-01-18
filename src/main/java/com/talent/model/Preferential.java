package com.talent.model;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author guobing
 * @Title: Preferential
 * @ProjectName shop-manager
 * @Description: TODO
 * @date 2019/1/18上午10:35
 */
@Setter
@Getter
public class Preferential implements Serializable {

    private Integer preferentialId;

    private Integer needNumber;

    private Integer discountNum;

    private Integer campusId;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
