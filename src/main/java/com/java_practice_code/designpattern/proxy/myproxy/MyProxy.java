package com.java_practice_code.designpattern.proxy.myproxy;

import org.springframework.util.FileCopyUtils;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2019/9/23.
 */
public class MyProxy {
    private static final String rt = "\r";

    public static Object newProxyInstance(MyClassLoader loader, Class<?> interfaces, MyInvocationHandler h) throws IllegalArgumentException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException {
        if (h == null) {
            throw new NullPointerException();
        }

        // 根据接口构造代理类：$MyProxy0
        Method[] methods = interfaces.getMethods();
        StringBuffer proxyClassString = new StringBuffer();
        proxyClassString.append("package ").append(loader.getProxyClassPackage()).append(";").append(rt)
                .append("import java.lang.reflect.Method;").append(rt)
                .append("public class $MyProxy0 implements ").append(interfaces.getName()).append("{").append(rt)
                .append("MyInvocationHandler h;").append(rt)
                .append("public $MyProxy0(MyInvocationHandler h){").append(rt)
                .append("this.h = h;}").append(rt)
                .append(getMethodString(methods, interfaces)).append("}");

        String filename = loader.getDir() + File.separator + "$MyProxy0.java";
        File myProxyFile = new File(filename);
        compile(proxyClassString, myProxyFile);
        Class $myProxy0 = loader.findClass("$MyProxy0");
        // $MyProxy0初始化
        Constructor constructor = $myProxy0.getConstructor(MyInvocationHandler.class);
        Object o = constructor.newInstance(h);
        return o;
    }

    private static void compile(StringBuffer proxyClassString, File myProxyFile) throws IOException {
        FileCopyUtils.copy(proxyClassString.toString().getBytes(), myProxyFile);
        JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager standardJavaFileManager = javaCompiler.getStandardFileManager(null, null, null);
        Iterable javaFileObjects = standardJavaFileManager.getJavaFileObjects(myProxyFile);
        JavaCompiler.CompilationTask task = javaCompiler.getTask(null, standardJavaFileManager, null, null, null, javaFileObjects);
        task.call();
        standardJavaFileManager.close();
    }

    private static String getMethodString(Method[] methods, Class interfaces) {
        StringBuffer methodStringBuffer = new StringBuffer();
        for (Method method : methods) {
            methodStringBuffer.append("public void ").append(method.getName())
                    .append("()").append("throws Throwable{")
                    .append("Method method1 = ").append(interfaces.getName())
                    .append(".class.getMethod(\"").append(method.getName())
                    .append("\", new Class[]{});")
                    .append("this.h.invoke(this, method1,null);}").append(rt);
        }
        return methodStringBuffer.toString();
    }
}