package com.fancv.MyLock;

import java.util.HashMap;
import java.util.Map;

/**
 * CPU占用100%
 * 无法分析原因
 *
 * 分析工具无法启动获取系统信息
 */
public class HashMapDeadLock {

    private final Map<String, String> map = new HashMap<>();

    public void put(String key, String value) {
        this.map.put(key, value);
    }

    public static void main(String[] args) {

        final HashMapDeadLock lock = new HashMapDeadLock();
        for (int x = 0; x < 2; x++) {
            new Thread(() -> {
                for (int i = 0; i < Integer.MAX_VALUE; i++) {
                    lock.put(String.valueOf(i), String.valueOf(i));
                }
            }).start();

        }

    }


}
