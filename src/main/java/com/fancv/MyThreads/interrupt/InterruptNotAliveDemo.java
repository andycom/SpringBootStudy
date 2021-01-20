package com.fancv.MyThreads.interrupt;

/**
 * 如果线程尚未启动(NEW)，或者已经结束(TERMINATED)，则调用interrupt()对它没有任何效果，中断标志位也不会被设置
 */
public class InterruptNotAliveDemo {
    private static class A extends Thread {
        @Override
        public void run() {
        }
    }

    public static void test() throws InterruptedException {
        A a = new A();
        a.interrupt();
        System.out.println(a.isInterrupted());

        a.start();
        Thread.sleep(100);
        a.interrupt();
        System.out.println(a.isInterrupted());
    }

    public static void main(String[] args) throws InterruptedException {
        test();
    }
}