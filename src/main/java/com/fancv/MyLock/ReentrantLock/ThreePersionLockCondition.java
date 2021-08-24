package com.fancv.MyLock.ReentrantLock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个线程，一个生产商 A 一个中间商B  一个消费者
 * 生产商 每次生产1个商品
 * 中间商每次运送 2个商品 ，消费者每次消费3个商品
 * 如果梳理不满足 则不运送 不消费
 */
public class ThreePersionLockCondition {

    private final static ReentrantLock lock = new ReentrantLock(true);

    private static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(9);
        Runnable target;
        Thread a = new Thread(new Produce(lock));
        a.start();

        executorService.submit(new Produce(lock));
        executorService.submit(new Middleman(lock));
        executorService.execute(new Consumer(lock));


        executorService.shutdown();
        executorService.awaitTermination(60, TimeUnit.SECONDS);
    }
}

/**
 * 生产者
 */
class Produce implements Runnable {

    Lock lock;

    public Produce(Lock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            System.out.println("生产1个产品");
        } finally {
            lock.unlock();
        }

    }
}

/**
 * 中间商
 */
class Middleman implements Runnable {

    Lock lock;

    public Middleman(Lock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            System.out.println("运输2个产品");
        } finally {
            lock.unlock();
        }
    }
}

/**
 * 消费者
 */
class Consumer implements Runnable {

    Lock lock;

    public Consumer(Lock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            System.out.println("消费2个产品");
        } finally {
            lock.unlock();
        }

    }

}