package com.java_practice_code.spring.aop;

import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    public String index() {
        return "hello, testservice with interface";
    }
}
