package com.java_practice_code.spring;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

//@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        DemoApplication demoApplication = new DemoApplication();
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.refresh();
        demoApplication.test4(annotationConfigApplicationContext);
    }

    private void test1(AnnotationConfigApplicationContext annotationConfigApplicationContext) {
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
        beanDefinition.setBeanClass(User.class);
        annotationConfigApplicationContext.registerBeanDefinition("user", beanDefinition);
        User user = annotationConfigApplicationContext.getBean("user", User.class);
        System.out.println(user);
    }

    private void test2(AnnotationConfigApplicationContext annotationConfigApplicationContext) {
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
        beanDefinition.setBeanClass(UserFactoryBean.class);
        annotationConfigApplicationContext.registerBeanDefinition("user", beanDefinition);
        User user = annotationConfigApplicationContext.getBean("user", User.class);
        UserFactoryBean userFactoryBean = annotationConfigApplicationContext.getBean("&user", UserFactoryBean.class);
        System.out.println(user);
        System.out.println(userFactoryBean);
    }

    private void test3(AnnotationConfigApplicationContext annotationConfigApplicationContext) {
        annotationConfigApplicationContext.registerBean(User.class);
        User user = annotationConfigApplicationContext.getBean("user", User.class);
        System.out.println(user);
    }

    private void test4(AnnotationConfigApplicationContext annotationConfigApplicationContext) {
        annotationConfigApplicationContext.registerBean(User.class, new Supplier<User>() {
            @Override
            public User get() {
                User user = new User();
                user.setName("ljx");
                return user;
            }
        });
        User user = annotationConfigApplicationContext.getBean("user", User.class);
        System.out.println(user);
        System.out.println(user.getName());
    }

}
