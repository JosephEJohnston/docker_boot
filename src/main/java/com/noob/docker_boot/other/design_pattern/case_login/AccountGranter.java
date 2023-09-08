package com.noob.docker_boot.other.design_pattern.case_login;

import org.springframework.stereotype.Component;

@Component
public class AccountGranter implements UserGranter {

    @Override
    public LoginResp login(LoginReq loginReq) {
        System.out.println("策略：登录方式为账号登录");

        // todo 执行业务操作

        return new LoginResp();
    }
}
