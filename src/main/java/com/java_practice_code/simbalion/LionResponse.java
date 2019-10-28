package com.java_practice_code.simbalion;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2019/9/24.
 */
public class LionResponse {
    private OutputStream outputStream;

    public LionResponse(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void write(String content) throws IOException {
        StringBuffer httpResponse = new StringBuffer();
        httpResponse.append("HTTP/1.1 200 OK\n")
                .append("Content-Type: text/html\n")
                .append("\r\n")
                .append("<html><body>")
                .append(content)
                .append("<body><html>");

        outputStream.write(httpResponse.toString().getBytes());
        outputStream.close();
    }
}
