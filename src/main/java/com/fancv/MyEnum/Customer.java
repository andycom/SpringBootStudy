

/*
 *  Copyright(c)2002-2020,  www.fancv.com
 *  项目名称:SpringBootStudy   SpringBootStudy
 *  文件名称:Customer.java
 *  Date:20-6-7 下午9:56
 *  Author: xixin
 */

package com.fancv.MyEnum;


public enum Customer {

    A("a", 12),
    B("b", 34);


    private String name;

    private Integer age;

    Customer(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


}
