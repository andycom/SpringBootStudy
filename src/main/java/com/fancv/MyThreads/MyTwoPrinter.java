package com.fancv.MyThreads;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @version 1.0
 * @Author hamish-wu
 * @create 2020/9/10 16:03
 * @Description
 */
public class MyTwoPrinter {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("两个线程交替打印信息");

        AtomicInteger a = new AtomicInteger(1);

        new Thread(new twoPrinter(a), "A").start();
        // 确保偶数线程线先获取到锁
        Thread.sleep(1);
        new Thread(new twoPrinter(a), "B").start();

    }
}


class twoPrinter implements Runnable {

    AtomicInteger a;

    public twoPrinter(AtomicInteger a) {
        this.a = a;
    }


    @Override
    public void run() {
        synchronized (a) {
            while (a.get() < 100) {
                System.out.println("线程: " + Thread.currentThread().getName());
                a.addAndGet(1);
                // 唤醒其他线程   先唤醒   synchronized 改良过 属于自旋锁，若线程wait之后  剩下的逻辑不会执行，不能唤醒其他线程

                a.notifyAll();
                try {
                    if (a.get() <= 100) {
                        // 如果任务还没有结束，则让出当前的锁并休眠
                        a.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}