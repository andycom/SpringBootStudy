package com.fancv.MyThreads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @version 1.0
 * @Author hamish-wu
 * @create 2020/7/31 15:31
 * @Description  每个线程随机获取锁，之后看共享状态state 是否满足此线程条件，如果满足打印，如果不满足释放锁，
 * 其他线程随机获取，这个效率有点低
 * 
 */

public class ABC_Lock {
    private static Lock lock = new ReentrantLock();// 通过JDK5中的Lock锁来保证线程的访问的互斥
    private static int state = 0;//通过state的值来确定是否打印

    static class ThreadA extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 100; ) {
                try {
                    lock.lock();
                    while (state % 3 == 0) {// 多线程并发，不能用if，必须用循环测试等待条件，避免虚假唤醒
                        System.out.println(Thread.currentThread().getName() + "A");
                        state++;
                        i++;
                    }
                } finally {
                    lock.unlock();// unlock()操作必须放在finally块中
                }
            }
        }
    }

    static class ThreadB extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 100; ) {
                try {
                    lock.lock();
                    while (state % 3 == 1) {
                        System.out.println(Thread.currentThread().getName() + "B");
                        state++;
                        i++;
                    }
                } finally {
                    lock.unlock();// unlock()操作必须放在finally块中
                }
            }
        }
    }

    static class ThreadC extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 100; ) {
                try {
                    lock.lock();
                    while (state % 3 == 2) {
                        System.out.println(Thread.currentThread().getName() + "C");
                        state++;
                        i++;
                    }
                } finally {
                    lock.unlock();// unlock()操作必须放在finally块中
                }
            }
        }
    }

    public static void main(String[] args) {
        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();
    }
}


