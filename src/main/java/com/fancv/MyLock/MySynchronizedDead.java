package com.fancv.MyLock;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

public class MySynchronizedDead {


    public static void main(String[] args) {
        Object a = new Object();
        Object b = new Object();
        System.out.println("多线程死锁");

        while (true) {
            Thread a1 = new Thread(new MyThreadA(a, b));
            Thread b1 = new Thread(new MyThreadA(b, a));
            a1.start();
            b1.start();
        }


    }

}

class MyThreadA implements Runnable {

    Object a;
    Object b;

    public MyThreadA(Object a, Object b) {
        this.a = a;
        this.b = b;
    }

    @SneakyThrows
    @Override
    public void run() {
        synchronized (a) {
            System.out.println("获取锁A " + Thread.currentThread().getState());
            TimeUnit.SECONDS.sleep(2);
            synchronized (b) {
                System.out.println("线程名称 " + Thread.currentThread().getName());
                System.out.println("获取锁B " + Thread.currentThread().getState());
            }

        }

    }


}
