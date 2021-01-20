package com.fancv.MyLock.MyLockDemo;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class BooleanLockTest {

    private final Lock lock = new BooleanLock();

    public void syncMethod() {
        try {
            lock.lock();
            int randomInt = ThreadLocalRandom.current().nextInt(10);
            System.out.println(Thread.currentThread() + " get the lock!  sleep: " + randomInt);
            TimeUnit.SECONDS.sleep(randomInt);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread() + " unlock!");
            lock.unlock();
        }
    }

    public void syncMethod2() {
        try {
            if (lock.TryLock()) {
                int randomInt = ThreadLocalRandom.current().nextInt(10);
                System.out.println(Thread.currentThread() + " get the lock!  开始工作 sleep: " + randomInt);
                TimeUnit.SECONDS.sleep(randomInt);
            } else {
                System.out.println(Thread.currentThread() + " 获取锁失败 线程不工作 直接结束");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread() + " unlock!");
            lock.unlock();
        }
    }

    public static void main(String[] args) {


        BooleanLockTest blt = new BooleanLockTest();
           /*IntStream.range(0, 10).mapToObj(i -> new Thread(blt::syncMethod2))
                .forEach(Thread::start);*/

        Thread a = new Thread(() -> blt.syncMethod2());
        Thread b = new Thread(() -> blt.syncMethod2());
        Thread c = new Thread(() -> blt.syncMethod2());
        a.start();
        b.start();
        c.start();


    }


}
