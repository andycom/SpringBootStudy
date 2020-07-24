package com.fancv.MyThreads;

import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @version 1.0
 * @Author hamish-wu
 * @create 2020/7/24 18:42
 * @Description
 */
public class CallableParameter {

    public static CopyOnWriteArrayList<String> arr = new CopyOnWriteArrayList<String>();

    public static void main(String[] args) {
        arr.add("a");
        arr.add("b");
        arr.add("c");
        arr.add("d");
        arr.add("e");
        arr.add("f");


        FutureTask<Integer> ft = null;
        for (int i = 0; i < 1000000; i++) {

            if (i % 10 == 2) {
                Callable<Integer> myCallable = new MyCallable(i);    // 创建MyCallable对象
                ft = new FutureTask<Integer>(myCallable); //使用FutureTask来包装MyCallable对象
                System.out.println(Thread.currentThread().getName() + " " + i);
                Thread thread = new Thread(ft);   //FutureTask对象作为Thread对象的target创建新的线程
                thread.start();                      //线程进入到就绪状态
            }
        }

        System.out.println("主线程for循环执行完毕..");

        try {                              //调用get方法会阻塞主线程等待结果，不调用则不会阻塞
            int sum = ft.get();            //取得新创建的新线程中的call()方法返回的结果
            System.out.println("sum = " + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

}

class MyCallable implements Callable<Integer> {
    private int i;

    public MyCallable(int i) {
        this.i = i;
    }

    // 与run()方法不同的是，call()方法具有返回值
    @Override
    public Integer call() {
        int sum = 0;
        for (; i < 6; i++) {
            System.out.println(Thread.currentThread().getName() + " ," + CallableParameter.arr.get(i));
            sum += 1;
        }
        return sum;
    }

}
