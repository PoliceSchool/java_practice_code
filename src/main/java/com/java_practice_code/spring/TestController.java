package com.java_practice_code.spring;

import com.java_practice_code.spring.springbeanandjavabeanlifecycle.MyQuery;
import com.java_practice_code.spring.springbeanandjavabeanlifecycle.ServiceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private ServiceBean serviceBean;

    @GetMapping("/home/index")
    public String index() {
        return "hello";
    }

    @RequestMapping(value = "/options", method = RequestMethod.OPTIONS)
    public void options() {

    }

    /**
     * MyQuery封装了后台页面传过来的查询参数，需要将这些查询参数转成查询语句再去Service里面查；
     * 因为基本上每一个MyQuery都需要转成查询语句，并且我认为这个转换过程是MyQuery的职责而不是Service的职责。所以我决定将这个转换方法写在MyQuery里面。
     * 这样Service直接调用MyQuery的转换方法即可查询出数据。
     * 但是这样会有一个问题，比如我现在要根据用户姓名查询该用户的所有订单，但是订单实体里面没有记录用户姓名，只有用户ID，所以需要先将用户姓名
     * 转成用户ID，然后通过用户ID去查询该用户的订单即可。
     * 但是这样又会有一个问题，MyQuery只是一个DTO，只在每次HTTP请求时生成，但是将用户姓名转成用户ID需要调用Service，一个DTO怎么去调用Spring注入
     * 的Bean呢？于是我就用ApplicationContext在MyQuery这里使用静态变量注入对应的Service，这样就可以直接调用Service的方法了。
     * 到这里一切都顺序运行，我得到了我想要的结果。但是我有个问题，MyQuery中的静态变量引用的是Spring管理的Bean，那么MyQuery的静态变量先生成呢
     * 还是Spring管理的Bean先生成呢？在java中类的静态变量优先于类的构造函数，所以MyQuery的静态变量应该先于Spring的Bean生成，但是这样的话
     * 就会造成NULL引用，造成空指针。但实际上却没有，程序顺利运行。我带着疑惑搜了一些java对象生命周期的资料，跟我的理解差不多。https://blog.csdn.net/m0_38110132/article/details/78842873
     * 于是我断点Service的构造函数与MyQuery的静态变量注入方法。结果我发现在Spring启动的过程中先断点了Service的构造函数。但是却没有断点MyQuery的
     * 静态注入方法。这时候我明白了，对象的静态变量只有在第一次构造对象的时候才会去生成，这么基础的知识我却没有想到·····
     * @param query
     */
    @RequestMapping(value = "/springbeanandjavabeanlifecycle", method = RequestMethod.GET)
    public String springbeanandjavabeanlifecycle(MyQuery query) {
        return serviceBean.getData(query);
    }
}
