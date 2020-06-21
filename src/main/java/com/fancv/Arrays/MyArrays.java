/*
 *  Copyright(c)2002-2020,  www.fancv.com
 *  项目名称:SpringBootStudy   SpringBootStudy
 *  文件名称:MyArrays.java
 *  Date:20-6-21 上午10:55
 *  Author: xixin
 */

package com.fancv.Arrays;

import java.util.Arrays;

public class MyArrays {

    public static void main(String args[]) {


        String[] a = {"1", "2", "C", "bank", "car", "bike", "iuf", "asdfs", "chakdfhab"};

        String[] b = Arrays.copyOfRange(a, 1, 3);


        for (String temp : b) {
            System.out.println(temp);
        }

        Arrays.sort(a);

        for (String temp : a) {
            System.out.println(temp);
        }

        DemoUser[] u = new DemoUser[4];

        u[0] = new DemoUser("kk", 2);
        u[1] = new DemoUser("kk1", 21);
        u[2] = new DemoUser("fk1", 12);
        u[3] = new DemoUser("ca1", 13);

        Arrays.sort(u);
        for (DemoUser temp : u) {
            System.out.println(temp.toString());
        }


    }
}


class DemoUser implements Comparable<DemoUser> {

    String name;
    Integer age;

    public DemoUser(String name, Integer age) {
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

    @Override
    public String toString() {
        return "DemoUser{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    /**
     * 按照年龄升序
     *
     * @param o
     * @return
     */

    @Override
    public int compareTo(DemoUser o) {
        return (this.getAge() > o.getAge()) ? 1 : -1;
    }
}
