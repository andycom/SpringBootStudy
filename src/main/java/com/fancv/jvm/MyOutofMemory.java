/*
 *  Copyright(c)2002-2020,  www.fancv.com
 *  项目名称:SpringBootStudy   SpringBootStudy
 *  文件名称:MyOutofMemory.java
 *  Date:20-6-20 下午4:28
 *  Author: xixin
 */

package com.fancv.jvm;

import java.util.LinkedList;
import java.util.List;

public class MyOutofMemory {

    public static void main(String args[]) {

        List<Demo> mylist = new LinkedList<>();
        while (Boolean.TRUE) {
            mylist.add(new Demo());
        }
    }

}

class Demo {

    public Demo() {
    }
}
