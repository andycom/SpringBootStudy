package com.fancv.MyThreads.interrupt;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

/**
 * Runnable 状态  thread.interrupt() 没有任何作用
 * interrupt 对  阻塞状态的线程起作用，可以打断阻塞
 * wait()
 * wait(long)
 * sleep(long)
 */
public class InterruptRunnableDemo extends Thread {
    @SneakyThrows
    @Override
    public void run() {
        synchronized (this) {
           /* while (!Thread.currentThread().isInterrupted()) {
                // ... 单次循环代码
                System.out.println("while 循环打印 " + Thread.currentThread().isInterrupted());
            }*/
            Thread.currentThread().interrupt();
            try {
                System.out.println("我被中断了 不显示 " + Thread.currentThread().isInterrupted());
                TimeUnit.MINUTES.sleep(1);
            } catch (final Exception e) {
                e.printStackTrace();
            }
            System.out.println("done " + Thread.currentThread().isInterrupted());
            /* Thread.currentThread().wait();*/
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new InterruptRunnableDemo();
        thread.start();
        System.out.println("线程名称：" + Thread.currentThread().getName());
        System.out.println("线程状态：" + Thread.currentThread().getState());
        //这里住进行 主线程 中断
       /* thread.interrupt();*/
    }
}