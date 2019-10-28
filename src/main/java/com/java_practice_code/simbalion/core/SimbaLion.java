package com.java_practice_code.simbalion.core;


import com.java_practice_code.simbalion.LionRequest;
import com.java_practice_code.simbalion.LionResponse;
import com.java_practice_code.simbalion.servlet.LionServlet;
import com.java_practice_code.simbalion.servlet.ServletMapping;
import com.java_practice_code.simbalion.servlet.ServletMappingConfig;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2019/9/24.
 */
public class SimbaLion {
    private int port = 8090;
    private Map<String, String> urlServletMap = new HashMap<>();

    public SimbaLion(int port) {
        this.port = port;
    }

    public void start() {
        // 初始化URL与对应的servlet的关系
        initServletMapping();
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("SimbaLion had started...");
            while (true) {
                Socket socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();

                LionRequest request = new LionRequest(inputStream);
                LionResponse response = new LionResponse(outputStream);

                // 分发请求
                dispatch(request, response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    private void initServletMapping() {
        for (ServletMapping servletMapping : ServletMappingConfig.servletMappingList) {
            urlServletMap.put(servletMapping.getUrl(), servletMapping.getClazz());
        }
    }

    private void dispatch(LionRequest request, LionResponse response) {
        String clazz = urlServletMap.get(request.getUrl());
        try {
            Class<LionServlet> lionServletClass = (Class<LionServlet>) Class.forName(clazz);
            LionServlet lionServlet = lionServletClass.newInstance();
            lionServlet.service(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SimbaLion(8090).start();
    }
}
