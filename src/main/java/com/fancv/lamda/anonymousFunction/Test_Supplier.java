/*
 *  Copyright(c)2002-2021,  www.fancv.com
 *  项目名称:SpringBootStudy   SpringBootStudy
 *  文件名称:Test_Supplier.java
 *  Date:21-1-27 下午10:09
 *  Author: xixin
 */

package com.fancv.lamda.anonymousFunction;
/**
 *
 */

import java.util.function.Supplier;

public class Test_Supplier {

    private static String test_Supplier(Supplier<String> suply) {
        return suply.get(); //供应者接口
    }

    public static void main(String[] args) {
        // 产生的数据作为 sout 作为输出
        System.out.println(test_Supplier(() -> "产生数据"));

        System.out.println((new Supplier<String>() {
            @Override
            public String get() {
                return "产生数据 匿名函数";
            }
        }).get());
    }
}
