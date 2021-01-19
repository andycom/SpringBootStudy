/*
 *  Copyright(c)2002-2021,  www.fancv.com
 *  项目名称:SpringBootStudy   SpringBootStudy
 *  文件名称:TestJoin.java
 *  Date:21-1-19 下午9:57
 *  Author: xixin
 */

package com.fancv.MyThreads.Join;


public class TestJoin {

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
        System.out.println(Thread.currentThread().getName() + " start");
        ThreadTest t1 = new ThreadTest("A");
        ThreadTest t2 = new ThreadTest("B");
        ThreadTest t3 = new ThreadTest("C");
        System.out.println("t1start");
        t1.start();
        System.out.println("t1end");
        System.out.println("t2start");
        t2.start();
        System.out.println("t2end");
        t1.join();

        //主线程被阻断，到T1
        System.out.println("t3start");
        t3.start();
        System.out.println("t3end");
        System.out.println(Thread.currentThread().getName() + " end");
    }

    static class ThreadTest extends Thread {
        private String name;

        public ThreadTest(String name) {
            this.name = name;
        }

        public void run() {
            for (int i = 1; i <= 5; i++) {
                System.out.println(name + "-" + i);
            }
        }


    }

}