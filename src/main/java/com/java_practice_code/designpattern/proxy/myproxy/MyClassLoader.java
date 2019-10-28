package com.java_practice_code.designpattern.proxy.myproxy;

import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2019/9/23.
 */
public class MyClassLoader extends ClassLoader {
    private File dir;
    private String proxyClassPackage;

    public File getDir() {
        return dir;
    }

    public String getProxyClassPackage() {
        return proxyClassPackage;
    }

    public MyClassLoader(String path, String proxyClassPackage) {
        this.dir = new File(path);
        this.proxyClassPackage = proxyClassPackage;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        if (dir != null) {
            File classFile = new File(dir, name + ".class");
            if (classFile.exists()) {
                try {
                    byte[] classBytes = FileCopyUtils.copyToByteArray(classFile);
                    return defineClass(proxyClassPackage + "," + name, classBytes, 0, classBytes.length);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        // 如果上述自定义的类没有加载到，走默认的加载方式
        return super.findClass(name);
    }
}
