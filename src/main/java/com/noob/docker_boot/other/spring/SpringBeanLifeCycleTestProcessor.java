package com.noob.docker_boot.other.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.stereotype.Component;

@Component
public class SpringBeanLifeCycleTestProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("springBeanLifeCycleTest")) {
            System.out.println("before 执行了 -> springBeanLifeCycleTest");
        }

        return bean;
    }

    // 可以在这步做代理
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("springBeanLifeCycleTest")) {
            System.out.println("after 执行了 -> springBeanLifeCycleTest");

            Enhancer enhancer = new Enhancer();

            enhancer.setSuperclass(bean.getClass());
            enhancer.setCallback((InvocationHandler) (proxy, method, args) -> {
                System.out.println("after: 我被增强了");
                return method.invoke(method, args);
            });

            return enhancer.create();
        }

        return bean;
    }
}
