package com.java_practice_code.spring.springbeanandjavabeanlifecycle;


import com.java_practice_code.spring.SpringUtil;

public class MyQuery {
    private static final ServiceBean SERVICE_BEAN = SpringUtil.getBeanByClass(ServiceBean.class);
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQueryString() {
        return SERVICE_BEAN.getQueryString(name);
    }
}
