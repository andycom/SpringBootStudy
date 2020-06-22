/*
 *  Copyright(c)2002-2020,  www.fancv.com
 *  项目名称:SpringBootStudy   SpringBootStudy
 *  文件名称:MyObject.java
 *  Date:20-6-21 下午2:33
 *  Author: xixin
 */

package com.fancv.MyObject;

public class MyObject {


    public static void main(String args[]) {

        Student s = new Student();
        System.out.println(s.getProtectName());

        s.getPublicName();

        Person p;

        //多态在 Java 程序设计语言中， 对象变量是多态的。 一个 Employee 变量既可以引用一个
        //Employee 类对象， 也可以引用一个 Employee 类的任何一个子类的对象（例如， Manager、
        //Executive、 Secretary 等）

        p=new Student();
    }
}
