package com.fancv.nio;

import java.nio.CharBuffer;

/**
 * @version 1.0
 * @Author hamish-wu
 * @create 2020/12/8 15:41
 * @Description
 */
public class Learn {
    public static void main(String[] args) {
        char[] charArray = new char[]{'a', 'b', 'c', 'd', 'e'};
        CharBuffer buffer = CharBuffer.wrap(charArray);
        System.out.println("A capacity()=" + buffer.capacity() + " limit()=" +
                buffer.limit());
        buffer.limit(5);
        System.out.println(buffer.position());
        System.out.println("B capacity()=" + buffer.capacity() + " limit()=" + buffer.limit());

        buffer.put(0, 'o'); //0
        System.out.println(buffer.position());
        buffer.put(1, 'p'); //1
        System.out.println(buffer.position());
        System.out.println(buffer.remaining());
        buffer.put(2, 'q'); //2
        buffer.put(3, 'r'); //3--此位置是第一个不可读不可写的索引
        buffer.put(4, 's'); //4
        buffer.put(5, 't'); //5
        buffer.put(6, 'u'); //6
    }

}
