package com.fancv.MyLock;

/**
 * @version 1.0
 * @Author hamish-wu
 * @create 2020/8/19 8:30
 * @Description
 */
public class SychnizedMathod extends Thread {


    public synchronized void syncprint(Object a, Object b) {
        System.out.println("1.打印线程：" + Thread.currentThread().getName());
        printd();

    }

    public void printd() {

        System.out.println("2.打印线程：" + Thread.currentThread().getName());

    }


    public static void main(String[] args) {


        Thread a = new SychnizedMathod();
        Thread b = new SychnizedMathod();

        a.start();
        b.start();

    }


}
