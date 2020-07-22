package com.fancv.MyThreads;

/**
 * @version 1.0
 * @Author hamish-wu
 * @create 2020/7/22 17:42
 * @Description
 */
public class ThreadStart {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new HelloThread();
        Thread thread2 = new HelloThread();
        System.out.println("thread1Name：" + thread.getName());
        System.out.println("thread1_Satate：" + thread.getState());
        thread.start();
        System.out.println("thread1_Satate：" + thread.getState());
        System.out.println("thread2_Satate：" + thread2.getState());
        Thread.sleep(2000);


        thread.join();
        System.out.println("thread1_Satate：" + thread.getState());
        System.out.println("thread2_Satate：" + thread2.getState());


        Thread helloThread = new Thread(new HelloRunnable());
        helloThread.start();

    }

}

/**
 * 继承Thread
 */

class HelloThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {
            System.out.println("hello");
            if (i == 10) {
                try {
                    sleep(2300);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

/**
 * java 实现runnable  接口
 */
class HelloRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("hello implement runnable");
    }
}
