package com.fancv.myCollentions;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hamish-wu
 */
public class MyHashMap {

    public static void main(String[] args) {
        System.out.println(1 << 16);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Math.pow(2,31));
        Map<String, Object> myHashMap = new HashMap<>(32);
        Map<String, Object> my = new HashMap<>();
        my.put("TEST","asd");

        myHashMap.put("1", "hello");
        myHashMap.put("2", "word");

        int s[] = new int[12];
        Object ob1 = new Object();
        Object ob2 = new Object();
        Object ob3 = new Object();
        Object ob4 = new Object();
        Object ob5 = new Object();
        Object ob6 = new Object();
        Object ob7 = new Object();
        Object ob8 = new Object();
        Object ob9 = new Object();
        Object ob10 = new Object();
        String s1="1";
        String s2="2";


        //10位int  hashcode
        System.out.println(15&ob1.hashCode());
        System.out.println(15&ob2.hashCode());
        System.out.println(15&ob2.hashCode());
        System.out.println(15&ob3.hashCode());
        System.out.println(15&ob4.hashCode());
        System.out.println(15&ob5.hashCode());
        System.out.println(15&ob6.hashCode());
        System.out.println(15&ob7.hashCode());
        System.out.println(15&ob8.hashCode());
        System.out.println(15&ob9.hashCode());
        System.out.println(15&ob10.hashCode());
        System.out.println(myHashMap.get("1"));


    }
}
