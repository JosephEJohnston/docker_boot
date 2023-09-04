package com.noob.docker_boot.other.spring;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringBeanLifeCycleTest implements
        BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean {

    public SpringBeanLifeCycleTest() {
        System.out.println("我的构造方法执行了。。。。。。。。。。");
    }

    private String name;

    @Value("张三")
    public void setName(String name) {
        System.out.println("setName 方法执行了。。。。。。。。");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("(BeanNameAware)setBeanName 方法执行了。。。。。。。。");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("(BeanFactoryAware)setBeanFactory 方法执行了。。。。。。。。");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("(ApplicationContextAware)setApplicationContext 方法执行了。。。。。。。。");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("(InitializingBean)afterPropertiesSet 方法执行了。。。。。。。。");
    }

    // 依赖注入完成后自动调用
    @PostConstruct // 实际由 BeanPostProcessor 处理，是 jdk 定义的初始化注解
    public void init() {
        System.out.println("(PostConstruct)init 方法执行了。。。。。。。。");
    }

    @PreDestroy
    private void destroy() {
        System.out.println("(PreDestroy)destroy 方法执行了。。。。。。。。");
    }

    /*
        我的构造方法执行了。。。。。。。。。。
        setName 方法执行了。。。。。。。。
        (BeanNameAware)setBeanName 方法执行了。。。。。。。。
        (BeanFactoryAware)setBeanFactory 方法执行了。。。。。。。。
        (ApplicationContextAware)setApplicationContext 方法执行了。。。。。。。。
        before 执行了 -> springBeanLifeCycleTest
        (PostConstruct)init 方法执行了。。。。。。。。
        (InitializingBean)afterPropertiesSet 方法执行了。。。。。。。。
        after 执行了 -> springBeanLifeCycleTest

        (PreDestroy)destroy 方法执行了。。。。。。。。
     */
}
