package com.fancv.MyThreads.interrupt;

import java.util.concurrent.TimeUnit;

public class BeforeSleepInterruptDemo {

    public static void main(String[] args) {
        System.out.println("1.Main: " + Thread.interrupted());
        Thread.currentThread().interrupt();
        System.out.println("2.Main: " + Thread.currentThread().isInterrupted());
        System.out.println("3.Main 线程状态: " + Thread.currentThread().getState());
        try {
            TimeUnit.SECONDS.sleep(10);
            System.out.println("4.Main 线程状态: " + Thread.currentThread().getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("will be interrupted still");
        }

    }
}
