/*
 *  Copyright(c)2002-2021,  www.fancv.com
 *  项目名称:SpringBootStudy   SpringBootStudy
 *  文件名称:MyClassLoader.java
 *  Date:2021/8/1 下午2:12
 *  Author: xixin
 */

package com.fancv.ClassLoader;

import java.lang.reflect.Method;

public class MyClassLoader {
    public static void main(String[] args) {

        ClassLoader c = MyClassLoader.class.getClassLoader();  //获取Test类的类加载器
        System.out.println(c);
        ClassLoader c1 = c.getParent();  //获取c这个类加载器的父类加载器
        System.out.println(c1);
        ClassLoader c2 = c1.getParent();//获取c1这个类加载器的父类加载器
        System.out.println(c2);

        WuClassLoader wl=new WuClassLoader();

        Class<?> aClass = wl.findClass("com.fancv.ClassLoader.MyTestDemo");

        try {
            Object obj = aClass.getDeclaredConstructor().newInstance();
            Method method = aClass.getMethod("test");
            method.invoke(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
