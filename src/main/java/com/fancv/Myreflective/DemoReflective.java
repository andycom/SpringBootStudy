/*
 *  Copyright(c)2002-2020,  www.fancv.com
 *  项目名称:SpringBootStudy   SpringBootStudy
 *  文件名称:DemoReflective.java
 *  Date:20-6-21 下午4:15
 *  Author: xixin
 */

package com.fancv.Myreflective;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class DemoReflective {

    public static void main(String args[]) {


        Car car = new Car();
        car.setBanch("红旗");
        Class cl = car.getClass();

        System.out.println(cl.getName());

        Method[] me = cl.getDeclaredMethods();
        System.out.println("---------------------");
        for (Method temp : me) {
            System.out.println(temp.getName());
        }

        Field[] fd = cl.getDeclaredFields();

        System.out.println("---------------------");
        for (Field temp : fd) {
            System.out.println(temp.getName());
            System.out.println(temp.getType());
        }

        try {
            Field fieldTag = cl.getDeclaredField("banch");
            fieldTag.setAccessible(true);
            String tag = (String) fieldTag.get(car);

            fieldTag.set(car,"长安");
            System.out.println("reflectPrivateField barnch = " + tag);
            System.out.println("reflectPrivateField barnch = " + car.getBanch());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
