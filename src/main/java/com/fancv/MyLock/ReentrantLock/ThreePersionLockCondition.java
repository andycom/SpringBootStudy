package com.fancv.MyLock.ReentrantLock;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个线程，一个生产商 A 一个中间商B  一个消费者C
 * 生产商 每次生产1个商品
 * 中间商每次运送 2个商品 ，消费者每次消费3个商品
 * 如果梳理不满足 则不运送 不消费
 */
public class ThreePersionLockCondition {

    private final static ReentrantLock lock = new ReentrantLock(true);

    private static Condition condition = lock.newCondition();
    private static Condition condition1 = lock.newCondition();

    private static Queue<String> queue = new ArrayDeque<>();
    private static Queue<String> queue2 = new ArrayDeque<>();

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(9);
        Runnable target;
        Thread a = new Thread(new Produce(lock, queue, condition));
        a.start();

        executorService.submit(new Produce(lock, queue, condition));
        executorService.submit(new Middleman(lock, queue, queue2, condition));
        executorService.execute(new Consumer(lock, queue2, condition));


        executorService.shutdown();
        executorService.awaitTermination(60, TimeUnit.SECONDS);
    }
}

/**
 * 生产者
 */
class Produce implements Runnable {

    Lock lock;
    Queue<String> queue;
    Condition condition;

    public Produce(Lock lock, Queue<String> queue, Condition condition) {
        this.lock = lock;
        this.queue = queue;
        this.condition = condition;
    }

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                while (queue.size() < 2) {
                    queue.add("1");
                    System.out.println("生产1个产品");
                    Thread.sleep(1000);
                    System.out.println("----生产队列剩余：" + queue.size());
                    condition.signal();
                }
                condition.await();
            } catch (final Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }
    }
}

/**
 * 中间商
 */
class Middleman implements Runnable {

    Lock lock;
    Queue<String> queue;
    Queue<String> queue2;
    Condition condition;


    public Middleman(Lock lock, Queue<String> queue, Queue<String> queue2, Condition condition) {
        this.lock = lock;
        this.queue = queue;
        this.queue2 = queue2;
        this.condition = condition;
    }

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                while (queue.size() > 1) {
                    System.out.println("运输2个产品");
                    String a = queue.poll();
                    String b = queue.poll();
                    queue2.add(a);
                    queue2.add(b);
                    condition.signalAll();

                }
                condition.await();


            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}

/**
 * 消费者
 */
class Consumer implements Runnable {

    Lock lock;
    Queue<String> queue2;
    Condition condition;

    public Consumer(Lock lock, Queue<String> queue2, Condition condition) {
        this.lock = lock;
        this.queue2 = queue2;
        this.condition = condition;
    }

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                while (queue2.size() > 2) {
                    for (int i = 0; i < 3; i++) {
                        System.out.println("消费产品：" + queue2.poll());
                    }
                    System.out.println("消费完成3个产品");
                    System.out.println("-----------消费队列剩余：" + queue2.size());
                    condition.signal();
                }
                condition.await();

            } catch (Exception e) {
            } finally {
                lock.unlock();
            }
        }
    }

}