package com.fancv.MyThreads;

/**
 * @version 1.0
 * @Author hamish-wu
 * @create 2020/7/31 14:26
 * @Description
 */
public class TwoPrinter {

    private int count = 0;
    private final Object lock = new Object();


    public static void main(String args[]) throws InterruptedException {

        new TwoPrinter().turning();
    }

    public void turning() throws InterruptedException {
        new Thread(new TurningRunner(), "A").start();
        // 确保偶数线程线先获取到锁
        Thread.sleep(1);
        new Thread(new TurningRunner(), "B").start();
    }


    class TurningRunner implements Runnable {
        @Override
        public void run() {
            while (count <= 100) {
                // 获取锁
                synchronized (lock) {
                    // 拿到锁就打印
                    System.out.println("线程名称：" + Thread.currentThread().getName() + ": " + count++);
                    // 唤醒其他线程
                    lock.notifyAll();
                    try {
                        if (count <= 100) {
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
