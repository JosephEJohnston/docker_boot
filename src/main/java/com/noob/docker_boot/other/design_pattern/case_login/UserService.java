package com.noob.docker_boot.other.design_pattern.case_login;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public LoginResp login(LoginReq loginReq) {
        switch (loginReq.getType()) {
            case "account" -> {
                System.out.println("用户名密码登录");
                return new LoginResp();
            }
            case "sms" -> {
                System.out.println("手机号验证码登录");
                return new LoginResp();
            }
            case "we_chat" -> {
                System.out.println("微信登录");
                return new LoginResp();
            }
        }

        LoginResp loginResp = new LoginResp();
        loginResp.setSuccess(false);
        System.out.println("登录失败");

        return loginResp;
    }
}
