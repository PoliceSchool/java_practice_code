package com.java_practice_code.jvm;

import java.io.IOException;
import java.io.InputStream;

// 来自《深入理解java虚拟机》第七章 虚拟机加载机制案例，在229页
public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Object obj = myLoader.loadClass("com.java_practice_code.jvm.ClassLoaderTest").newInstance();
        System.out.println(obj.getClass());
        // 虚拟机中存在两个ClassLoaderTest类，一个是自己的类加载器加载的，另一个是JVM自己的类加载器加载的
        System.out.println(obj instanceof com.java_practice_code.jvm.ClassLoaderTest);
    }
}
