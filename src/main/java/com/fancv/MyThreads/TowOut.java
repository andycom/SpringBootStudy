package com.fancv.MyThreads;

/**
 * @author hamish-wu
 */
public class TowOut {
    private final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {

        new TowOut().turning();

    }

    public void turning() throws InterruptedException {
        new Thread(new TowOut.Print(), "A").start();
        // 确保偶数线程线先获取到锁
        Thread.sleep(1);
        new Thread(new TowOut.Print(), "B").start();
    }


    class Print implements Runnable {

        @Override
        public void run() {

            while (ints.m <= 1000) {
                synchronized (lock) {
                    System.out.println("Thread: " + Thread.currentThread().getName() + "\t" + ints.getint());
                    lock.notify();
                    try {
                        if (ints.m <= 1000) {
                            // 如果任务还没有结束，则让出当前的锁并休眠
                            lock.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }

        }
    }

}

class ints {

    static int m = 1;

    static int getint() {
        return ++m;

    }
}