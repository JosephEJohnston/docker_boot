package com.noob.docker_boot.other.design_pattern.case_login;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginReq {
    private String name;
    private String password;

    private String phone;
    private String validateCode;

    private String wxCode;

    /*
     * account: 用户名密码登录
     * sms: 手机验证码登录
     * we_chat: 微信登录
     */
    private String type;
}
