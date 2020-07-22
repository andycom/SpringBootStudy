package com.fancv.MyThreads;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @Author hamish-wu
 * @create 2020/7/22 19:07
 * @Description 线程通过构造方法 传入参数
 */
public class ShareMemoryDemo {
    private static int shared = 0;

    private static void incrShared() {
        shared++;
    }

    static class ChildThread extends Thread {
        List<String> list;

        public ChildThread(List<String> list) {
            this.list = list;
        }

        @Override
        public void run() {
            incrShared();
            list.add(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<String>();
        Thread t1 = new ChildThread(list);
        Thread t2 = new ChildThread(list);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(shared);
        System.out.println(list);
    }
}
