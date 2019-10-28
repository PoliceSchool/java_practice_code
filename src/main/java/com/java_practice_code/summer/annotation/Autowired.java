package com.java_practice_code.summer.annotation;

import java.lang.annotation.*;

/**
 * @author ljx
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Autowired {
    String value();
}
