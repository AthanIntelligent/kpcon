package com.aiden.kpcon.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * user
 * @author 
 */
@Data
public class User implements Serializable {
    /**
     * 用户id
     */
    private String id;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 微信openId
     */
    private String wxOpenId;

    /**
     * 微信unionId
     */
    private String wxUnionId;

    /**
     * 微信昵称
     */
    private String wxNickname;

    /**
     * 微信用户头像URL
     */
    private String wxHeadimgUrl;

    /**
     * 微信性别
     */
    private Integer wxGender;

    /**
     * 微信国家
     */
    private String wxCountry;

    /**
     * 微信省份
     */
    private String wxProvince;

    /**
     * 微信城市
     */
    private String wxCity;

    /**
     * 微信语言
     */
    private String wxLanguage;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号码
     */
    private String phoneNumber;

    /**
     * 身份证号
     */
    private String identityNumber;

    /**
     * 身份证名
     */
    private String identityName;

    /**
     * 登录系统ip
     */
    private String loginIp;

    /**
     * 最后登录时间
     */
    private Date lastLoginTime;

    /**
     * 区域编码
     */
    private String areaCode;

    private static final long serialVersionUID = 1L;
}