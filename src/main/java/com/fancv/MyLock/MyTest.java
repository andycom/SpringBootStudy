package com.fancv.MyLock;

/**
 * @version 1.0
 * @Author hamish-wu
 * @create 2020/8/19 8:42
 * @Description
 */
public class MyTest {

    public static void main(String[] args) {
        Object a = new Object();
        Object b = new Object();
        Thread a1 = new Thread(new print(a, b));
        Thread b1 = new Thread(new print(b, a));
        a1.start();
        b1.start();
    }

}

class print implements Runnable {

    Object a;
    Object b;

    public print(Object a, Object b) {
        this.a = a;
        this.b = b;
    }
    @Override
    public void run() {
        try {
            synchronized (a) {
                Thread.sleep(2000);
                System.out.println("A锁线程打印" + Thread.currentThread().getName());
                synchronized (b) {
                    System.out.println("B锁 线程打印" + Thread.currentThread().getName());
                }
            }
        } catch (Exception e) {

        }


    }
}
