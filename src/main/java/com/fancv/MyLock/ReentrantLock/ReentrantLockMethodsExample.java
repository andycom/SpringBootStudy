/*
 *  Copyright(c)2002-2021,  www.fancv.com
 *  项目名称:SpringBootStudy   SpringBootStudy
 *  文件名称:ReentrantLockMethodsExample.java
 *  Date:21-2-17 下午6:00
 *  Author: xixin
 */

package com.fancv.MyLock.ReentrantLock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class ReentrantLockMethodsCounter {
    private final ReentrantLock lock = new ReentrantLock();

    private int count = 0;

    public int incrementAndGet() {
        // Check if the lock is currently acquired by any thread
        System.out.println("IsLocked : " + lock.isLocked());

        // Check if the lock is acquired by the current thread itself.
        System.out.println("IsHeldByCurrentThread : " + lock.isHeldByCurrentThread());

        // Try to acquire the lock
        boolean isAcquired;
        try {
            lock.lock();
            Thread.sleep(2000);
            count = count + 1;
            System.out.println(Thread.currentThread().getName() +" -Lock Acquired : " + lock.getHoldCount() + "\n");
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }finally {
            lock.unlock();
        }

        /*if (isAcquired) {
            System.out.println(Thread.currentThread().getName() +" -Lock Acquired : " + isAcquired + "\n");
            try {
                Thread.sleep(2000);
                count = count + 1;
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            } finally {
                lock.unlock();
            }
        }*/
        return count;
    }
}

public class ReentrantLockMethodsExample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        ReentrantLockMethodsCounter lockMethodsCounter = new ReentrantLockMethodsCounter();

        executorService.submit(() -> {
            System.out.println("IncrementCount (First Thread) : " +
                    lockMethodsCounter.incrementAndGet() + "\n");
        });

        executorService.submit(() -> {
            System.out.println("IncrementCount (Second Thread) : " +
                    lockMethodsCounter.incrementAndGet() + "\n");
        });
        executorService.submit(() -> {
            System.out.println("IncrementCount (3Thread) : " +
                    lockMethodsCounter.incrementAndGet() + "\n");
        });
        executorService.submit(() -> {
            System.out.println("IncrementCount (4 Thread) : " +
                    lockMethodsCounter.incrementAndGet() + "\n");
        });
        executorService.submit(() -> {
            System.out.println("IncrementCount (5 Thread) : " +
                    lockMethodsCounter.incrementAndGet() + "\n");
        });

        executorService.shutdown();
    }
}