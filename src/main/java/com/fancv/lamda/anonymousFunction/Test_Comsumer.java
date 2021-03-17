/*
 *  Copyright(c)2002-2021,  www.fancv.com
 *  项目名称:SpringBootStudy   SpringBootStudy
 *  文件名称:Test_Comsumer.java
 *  Date:21-1-27 下午10:39
 *  Author: xixin
 */

package com.fancv.lamda.anonymousFunction;

import java.util.function.Consumer;

public class Test_Comsumer {
    public static void generateX(Consumer<String> consumer) {
        consumer.accept("hello consumer");
    }
    public static void main(String[] args) {
        generateX(s->System.out.println(s));
    }
}