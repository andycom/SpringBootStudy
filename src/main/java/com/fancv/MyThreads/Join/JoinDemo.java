/*
 *  Copyright(c)2002-2021,  www.fancv.com
 *  项目名称:SpringBootStudy   SpringBootStudy
 *  文件名称:JoinDemo.java
 *  Date:21-1-19 下午9:36
 *  Author: xixin
 */

package com.fancv.MyThreads.Join;

import java.util.concurrent.TimeUnit;

public class JoinDemo extends Thread {

    public static void main(String args[]) {
        System.out.println("thread" +
                "join");


        Thread a = new JoinDemo();
        a.start();
        //Main 主线程join  thread a
        try {
            a.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Main 打印");
    }


    @Override
    public void run() {

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("xiancheng yunxing");
    }
}
