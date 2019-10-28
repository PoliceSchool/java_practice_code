package com.java_practice_code.simbalion.servlet;


import com.java_practice_code.simbalion.LionRequest;
import com.java_practice_code.simbalion.LionResponse;

import java.io.IOException;

/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2019/9/24.
 */
public class UserServlet extends LionServlet {
    @Override
    public void doGet(LionRequest request, LionResponse response) {
        try {
            response.write("get user...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(LionRequest request, LionResponse response) {
        try {
            response.write("post user...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
