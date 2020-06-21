/*
 *  Copyright(c)2002-2020,  www.fancv.com
 *  项目名称:SpringBootStudy   SpringBootStudy
 *  文件名称:Student.java
 *  Date:20-6-21 下午2:34
 *  Author: xixin
 */

package com.fancv.MyObject;

public class Student extends Person {

    Integer age;

    public Student(String name, Integer age) {
        super(name);
        this.age = age;
    }

    public Student(Integer age) {
        this.age = age;
    }

    public Student() {
        super.names();
        System.out.println("Student init 3");
    }

    @Override
    protected void names() {
        super.names();

    }
}
