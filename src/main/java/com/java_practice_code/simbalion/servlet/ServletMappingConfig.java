package com.java_practice_code.simbalion.servlet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2019/9/24.
 */
public class ServletMappingConfig {
    public static List<ServletMapping> servletMappingList = new ArrayList<>(2);

    static {
        servletMappingList.add(new ServletMapping("index", "/findIndex", "com.simbalion.servlet.IndexServlet"));
        servletMappingList.add(new ServletMapping("user", "/findUser", "com.simbalion.servlet.UserServlet"));
    }
}
