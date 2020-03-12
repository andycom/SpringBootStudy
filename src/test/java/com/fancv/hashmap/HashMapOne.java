package com.fancv.hashmap;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0
 * @Author hamish-wu
 * @create 2020/3/12 11:07
 * @Description
 */
public class HashMapOne {

    Map<String, Object> map = new HashMap<String, Object>(16);

    @Test
    public void testHashMap() {
        System.out.println("helo");
        map.put("1",2);
        map.put("2","dsd");
        map.put("3",2);
        map.put("4","dsd");
        map.put("5",2);
        map.put("6","dsd");

        System.out.println(map.isEmpty());
        System.out.println(map.size());

    }

}
