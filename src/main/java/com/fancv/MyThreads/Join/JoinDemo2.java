/*
 *  Copyright(c)2002-2021,  www.fancv.com
 *  项目名称:SpringBootStudy   SpringBootStudy
 *  文件名称:JoinDemo2.java
 *  Date:21-1-19 下午10:03
 *  Author: xixin
 */

package com.fancv.MyThreads.Join;

public class JoinDemo2 {
    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                System.out.println("t1 开始运行!");
                Thread t2 = new Thread() {
                    @Override
                    public void run() {
                        System.out.println("t2 开始运行!");
                        try {
                            Thread.sleep(3000);
                        } catch (Exception e) {
                        }
                        System.out.println("t2 结束运行!");
                    }
                };
                t2.start();
                try {
                    t2.join();
                    System.out.println("1.线程T2Status：" + t2.getState());
                    //线程T1 join 到T2  等待t2 运行结束之后T1 在运行
                } catch (Exception e) {
                }

                System.out.println("t1 结束运行!");
            }
        };
        System.out.println("2.线程T1Status：" + t1.getState());
        t1.start();
        System.out.println("3.线程T1Status：" + t1.getState());
    }

}
