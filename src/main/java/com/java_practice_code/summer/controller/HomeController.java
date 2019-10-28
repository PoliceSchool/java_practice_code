package com.java_practice_code.summer.controller;


import com.java_practice_code.summer.annotation.Autowired;
import com.java_practice_code.summer.annotation.Controller;
import com.java_practice_code.summer.annotation.RequestMapping;
import com.java_practice_code.summer.service.HomeService;

/**
 * @author ljx
 */
@Controller("homeController")
@RequestMapping("/home")
public class HomeController {

    @Autowired("homeServiceImpl")
    private HomeService homeService;

    @RequestMapping("/index")
    public void index() {
        homeService.index();
    }
}
