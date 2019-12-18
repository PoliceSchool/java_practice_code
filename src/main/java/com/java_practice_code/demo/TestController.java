package com.java_practice_code.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/index")
    public String index() {
        return "hello";
    }

    @RequestMapping(value = "/options", method = RequestMethod.OPTIONS)
    public void options() {

    }
}
