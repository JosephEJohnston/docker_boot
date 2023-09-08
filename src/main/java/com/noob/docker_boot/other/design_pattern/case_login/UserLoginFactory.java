package com.noob.docker_boot.other.design_pattern.case_login;

import jakarta.annotation.Resource;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class UserLoginFactory implements ApplicationContextAware {

    private static final Map<String, UserGranter> granterPool = new ConcurrentHashMap<>();

    @Resource
    private LoginTypeConfig loginTypeConfig;

    /**
     * 从配置文件中读取策略信息存储到 map 中
     * {
     *     account: accountGranter,
     *     sms: smsGranter,
     *     we_chat: weChatGranter
     * }
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        loginTypeConfig.getTypes().forEach((k, v) ->
                granterPool.put(k, (UserGranter) applicationContext.getBean(v)));
    }

    /**
     * 对外提供获取具体策略
     */
    public UserGranter getGranter(String grantType) {
        return granterPool.get(grantType);
    }
}
