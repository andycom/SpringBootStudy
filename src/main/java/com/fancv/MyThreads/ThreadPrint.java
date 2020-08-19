package com.fancv.MyThreads;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @version 1.0
 * @Author hamish-wu
 * @create 2020/7/30 19:47
 * @Description
 */
public class ThreadPrint {


    public static void main(String args[]) throws InterruptedException {
        System.out.println("四个线程交替打印数字");
        AtomicInteger im = new AtomicInteger(1);
        List<Integer> list = new LinkedList<Integer>();

        for (int i = 1; i < 100; i++) {
            list.add(i);
        }

        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Thread thread1 = new printer(list, lock, condition);
        Thread thread2 = new printerB(list, lock, condition);
       /* Thread thread3 = new printer(im, lock, condition);
        Thread thread4 = new printer(im, lock, condition);
        Thread thread5 = new printer(im, lock, condition);
        Thread thread6 = new printerB(im, lock, condition);
        Thread thread7 = new printer(im, lock, condition);
        Thread thread8 = new printer(im, lock, condition);*/
        thread1.start();
        thread2.start();
       /* thread4.start();
        thread3.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();*/

    }
}


class printer extends Thread {

    private List<Integer> list;
    private Lock lock;
    private Condition condition;

    public printer(List<Integer> list, Lock lock, Condition condition) {
        this.list = list;
        this.lock = lock;
        this.condition = condition;
    }

    public void run() {
        try {

            while (list.size() > 0) {
                lock.lock();
                System.out.println("1线程名称：" + Thread.currentThread().getName() + " 线程id：" + Thread.currentThread().getId() + " 打印 ： " + list.get(list.size()-1));
                list.remove(list.size()-1);
                lock.unlock();
            }


        } catch (Exception e) {
            Thread.interrupted();
            e.printStackTrace();
        } finally {
            condition.signal();
        }
    }

}

class printerB extends Thread {

    private List<Integer> list;
    private AtomicInteger i;
    private Lock lock;
    private Condition condition;

    public printerB(List<Integer> list, Lock lock, Condition condition) {
        this.list = list;
        this.lock = lock;
        this.condition = condition;
    }

    public void run() {
        try {
            while (list.size() > 0) {
                lock.lock();
                System.out.println("1线程名称：" + Thread.currentThread().getName() + " 线程id：" + Thread.currentThread().getId() + " 打印 ： " + list.get(list.size()-1));
                list.remove(list.size()-1);
                lock.unlock();
            }


        } catch (Exception e) {
            Thread.interrupted();
            e.printStackTrace();
        } finally {
            condition.signal();
        }
    }
}

