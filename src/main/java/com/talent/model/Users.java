package com.talent.model;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author guobing
 * @Title: Users
 * @ProjectName shop-manager
 * @Description: 用户实体类
 * @date 2019/1/16下午5:37
 */
@Setter
@Getter
public class Users implements Serializable {
    private String phone;

    private String password;

    private Short type;

    private String nickname;

    private String imgUrl;

    private Date lastLoginDate;

    private Date createTime;

    private String defaultAddress;

    private String token;

    private Short sex;

    private String academy;

    private String qq;

    private String weiXin;

    private Integer campusId;

    public Users(String phone2, String password2, String nickname2) {
        phone = phone2;
        password = password2;
        nickname = nickname2;
        type = 2;
        createTime = new Date();
        lastLoginDate = new Date();
    }

    public Users() {
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
