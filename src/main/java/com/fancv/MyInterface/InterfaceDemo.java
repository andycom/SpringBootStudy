package com.fancv.MyInterface;

/**
 * @version 1.0
 * @Author hamish-wu
 * @create 2020/6/29 9:24
 * @Description
 */
public interface InterfaceDemo {

    public void printfl(String s);

    default void printfq(String s) {

    }

    public static void printfdd(String s) {
        System.out.println(s);
    }
}
