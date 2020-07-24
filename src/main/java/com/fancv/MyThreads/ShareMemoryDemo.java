package com.fancv.MyThreads;

import java.util.List;
import java.util.concurrent.*;

/**
 * @version 1.0
 * @Author hamish-wu
 * @create 2020/7/22 19:07
 * @Description 线程通过构造方法 传入参数`````````````
 */
public class ShareMemoryDemo {
    private static int shared = 0;

    private static void incrShared() {
        shared++;
    }

    static class ChildThread extends Thread {
        List<String> list;

        public ChildThread(List<String> list) {
            this.list = list;
        }

        @Override
        public void run() {
            incrShared();
            list.add(Thread.currentThread().getName());
        }
    }


    public static void threadGrounp() {
        Runnable runnable = () -> {
            System.out.println("Java技术栈线程线程组名称：" + Thread.currentThread().getThreadGroup());
            System.out.println("Java技术栈线程线程名称：" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        ThreadGroup userGroup = new ThreadGroup("user");
        userGroup.setMaxPriority(Thread.MIN_PRIORITY);

        Thread userTask1 = new Thread(userGroup, runnable, "user-task1");
        Thread userTask2 = new Thread(userGroup, runnable, "user-task2");

        userTask1.start();
        userTask2.start();

        System.out.println("Java技术栈线程线程组活跃线程数：" + userGroup.activeCount());
        userGroup.list();

    }

    public static void main(String[] args) throws InterruptedException {
      /*  List<String> list = new ArrayList<String>();
        Thread t1 = new ChildThread(list);
        Thread t2 = new ChildThread(list);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(shared);
        System.out.println(list);*/

        threadGrounp();

        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        // 启动线程
        Future<String> stringFuture = threadPool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "nihao";
            }
        });
        try {
            System.out.println(stringFuture.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

}
