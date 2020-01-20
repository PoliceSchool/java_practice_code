package com.java_practice_code.spring.springbeanandjavabeanlifecycle;

import org.springframework.stereotype.Service;

/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2020/1/20.
 */
@Service
public class ServiceBean {
    public String getQueryString(String name) {
        // 根据用户姓名去数据库查到对应的UserId
        return "234";
    }

    public String getData(MyQuery query) {
        return getData(query.getQueryString());
    }

    private String getData(String queyString) {
        return "aaaaa";
    }
}
