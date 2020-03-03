package com.java_practice_code.spring.aop;

import org.springframework.stereotype.Service;

@Service
public class TestService2 {
    @TestAnnotation(msg = "i am msg, without interface")
    public String index() {
        return "hello, testservice without interface";
    }
}
