package com.fancv.MyThreads;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hamish-wu
 */
public class MyStack {

    private List<String> list = new ArrayList<String>();

    public synchronized void push(String value) {
        synchronized (this) {
            list.add(value);
            notify();
        }
    }

    public synchronized String pop() throws InterruptedException {
        synchronized (this) {
            if (list.size() <= 0) {
             /*   wait();*/
                Thread.sleep(1000000);
            }
            return list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        MyStack myStack = new MyStack();

        new Thread(() -> {
            try {
                myStack.pop();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        Thread.sleep(1000);
        new Thread(() -> myStack.push("dd")).start();
    }

}
