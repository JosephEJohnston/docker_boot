package com.noob.docker_boot.other.design_pattern.case_login;

// 抽象策略类
public interface UserGranter {


    LoginResp login(LoginReq loginReq);
}
