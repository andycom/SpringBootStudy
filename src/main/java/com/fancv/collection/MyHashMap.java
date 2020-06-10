package com.fancv.collection;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class MyHashMap {
    public static void main(String args[]) {
        Map<String, String> my = new HashMap();


        my.put("1", "hello");
        my.put("2", "word");

        System.out.println(my.get("1"));
        my.put("1", "dadfas");
        add();
        System.out.println(my.get("1"));


    }

    public static void add() {
        int a = 1, b = 3;

        Integer s = a + b;
    }
}
