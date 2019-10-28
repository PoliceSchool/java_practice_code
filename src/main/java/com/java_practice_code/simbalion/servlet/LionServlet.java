package com.java_practice_code.simbalion.servlet;


import com.java_practice_code.simbalion.LionRequest;
import com.java_practice_code.simbalion.LionResponse;

/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2019/9/24.
 */
public abstract class LionServlet {
    public static final String GET_STR = "GET";
    public static final String POST_STR = "POST";

    public abstract void doGet(LionRequest request, LionResponse response);

    public abstract void doPost(LionRequest request, LionResponse response);

    public void service(LionRequest request, LionResponse response) {
        String requestMethod = request.getMethod();
        if (POST_STR.equalsIgnoreCase(requestMethod)) {
            doPost(request, response);
        } else if (GET_STR.equalsIgnoreCase(requestMethod)) {
            doGet(request, response);
        }
    }
}
