package com.java_practice_code.summer.annotation;

import java.lang.annotation.*;

/**
 * @author ljx
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Service {
    String value();
}
