/*
 *  Copyright(c)2002-2020,  www.fancv.com
 *  项目名称:SpringBootStudy   SpringBootStudy
 *  文件名称:Person.java
 *  Date:20-6-21 下午2:33
 *  Author: xixin
 */

package com.fancv.MyObject;

import java.util.Objects;

public class Person {

    private String name;

    public Person(String name) {

        System.out.println("Person init   2");
        this.name = name;
    }

    public Person() {

        System.out.println("Person init  1");

    }


    private String getName() {
        return this.name;
    }


    protected void names() {
        System.out.print("names");
    }


    public String getPublicName() {
        return "public";
    }

    protected String getProtectName() {
        return "protect";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(getName(), person.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
