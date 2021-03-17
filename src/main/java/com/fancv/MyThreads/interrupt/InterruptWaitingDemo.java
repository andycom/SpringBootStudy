package com.fancv.MyThreads.interrupt;

public class InterruptWaitingDemo extends Thread {
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                // 模拟任务代码
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("e = " + e);
                // ... 清理操作
                //false
                System.out.println(isInterrupted());
                // 重设中断标志位为true
                Thread.currentThread().interrupt();
            }
        }
        //true
        System.out.println(isInterrupted());
    }

    public static void main(String[] args) {
        InterruptWaitingDemo thread = new InterruptWaitingDemo();
        thread.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("e = " + e);
            e.printStackTrace();
        }
        thread.interrupt();
    }
}

