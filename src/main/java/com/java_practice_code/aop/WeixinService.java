package com.java_practice_code.aop;

import org.springframework.stereotype.Service;

/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2019/9/6.
 */
@Service
public class WeixinService {
    public void share(String articleUrl) {
        System.out.println("Share article:" + articleUrl);
    }

    public void shareProxy(String articleUrl) {
        share("sssss" + articleUrl);
    }
}
