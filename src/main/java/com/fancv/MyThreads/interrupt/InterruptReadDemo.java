package com.fancv.MyThreads.interrupt;

import java.io.IOException;

public class InterruptReadDemo {
    private static class A extends Thread {
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    //wait input
                    System.out.println(System.in.read());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("exit");
        }

        public void cancel() {
            System.out.println("关闭输入流");
            try {
                System.in.close();
                System.out.println(Thread.currentThread().getState());
            } catch (IOException e) {
                e.printStackTrace();
            }
            interrupt();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        A t = new A();
        t.start();
        Thread.sleep(10);
        /*    t.interrupt();*/
        System.out.println("main "+Thread.currentThread().getState());
        t.cancel();

    }
}