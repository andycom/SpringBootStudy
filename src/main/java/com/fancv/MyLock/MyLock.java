package com.fancv.MyLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @version 1.0
 * @Author hamish-wu
 * @create 2020/8/18 8:34
 * @Description
 */
public class MyLock {


    public static void main(String[] args) throws InterruptedException {
        Lock la = new ReentrantLock();
        Lock lb = new ReentrantLock();

        Thread a = new Thread(new printa(la, lb));
        Thread b = new Thread(new printb(la, lb));
        a.start();
        b.start();
        a.join();
        b.join();


    }


}


class printa implements Runnable {


    private Lock a;
    private Lock b;

    public printa(Lock a, Lock b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {

        try {

            System.out.println("A1" + a.tryLock());
            Thread.sleep(2000);
            System.out.println("A2" + b.tryLock());
            while (a.tryLock()) {
                if (b.tryLock()) {
                    System.out.println("A");
                } else {

                }
            }

        } catch (Exception e) {
            a.unlock();
            b.unlock();
        }
       /* a.unlock();
        b.unlock();*/
    }
}

class printb implements Runnable {

    private Lock a;
    private Lock b;

    public printb(Lock a, Lock b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        try {
            System.out.println("B1" + b.tryLock());
            Thread.sleep(2000);
            System.out.println("B2" + a.tryLock());

            while (b.tryLock()) {
                if (a.tryLock()) {
                    System.out.println("B");
                }
            }
        } catch (Exception e) {
            a.unlock();
            b.unlock();
        }
    }
}





