package com.java_practice_code.spring.aop;

public interface TestService {
    @TestAnnotation(msg = "i am msg, with interface")
    String index();
}
