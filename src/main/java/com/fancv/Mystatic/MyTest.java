/*
 *  Copyright(c)2002-2021,  www.fancv.com
 *  项目名称:SpringBootStudy   SpringBootStudy
 *  文件名称:MyTest.java
 *  Date:21-1-30 下午11:01
 *  Author: xixin
 */

package com.fancv.Mystatic;

public class MyTest {
    static {
        test1();
    }

    public static void main(String args[]) {

        System.out.println("Static 块中能否调用静态方法");

        test1();


    }

    public static void test1() {
        System.out.println("静态方法被调用");
    }

    public void test2() {
        System.out.println("实例方法被调用");
    }
}
