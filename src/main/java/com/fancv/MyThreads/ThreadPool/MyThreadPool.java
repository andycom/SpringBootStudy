package com.fancv.MyThreads.ThreadPool;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.*;

/**
 * 线程池研究
 */
public class MyThreadPool {
    public static void main(String[] args) {

        //创建一个不限制线程个数的线程池
        ExecutorService executor = new ScheduledThreadPoolExecutor(2,
                new BasicThreadFactory.Builder().namingPattern("commonlang3-example-schedule-pool-%d").daemon(true).build());
        //创建一个固定线程个数的线程池
        ExecutorService executor2 = new ThreadPoolExecutor(4, 8,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());


        executor2.submit(new Thread(() -> System.out.println("线程启动")));
        executor2.shutdown();

    }
}
