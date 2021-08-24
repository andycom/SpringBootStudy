package com.fancv.collection;

import java.util.Map;
import java.util.concurrent.*;

public class MyCurrentHashMap {

    public static void main(String args[]) throws InterruptedException {

        Map<String, String> currhashMap = new ConcurrentHashMap<String, String>();

        currhashMap.put("115", "first");
        currhashMap.put("112", "second");


        //创建一个固定线程个数的线程池
        ExecutorService executor2 = new ThreadPoolExecutor(4, 8,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());


        executor2.submit(new Thread(() -> System.out.println("线程启动")));
        for (int i = 0; i < 1000; i++) {
            executor2.submit(new myIi(i, currhashMap));
        }
        executor2.shutdown();

        Thread.sleep(100);

        for (String key : currhashMap.keySet()) {
            System.out.println("key : " + key);
            System.out.println("value : " + currhashMap.get(key));
        }


    }


}

class myIi extends Thread {
    Map<String, String> tcurrhashMap;
    int i;

    myIi(int i, Map<String, String> currhashMap) {
        this.tcurrhashMap = currhashMap;
        this.i = i;
    }

    ThreadLocalRandom random = ThreadLocalRandom.current();

    @Override
    public void run() {
        tcurrhashMap.put(Integer.toString(i), Integer.toString(random.nextInt()));
        //这里写计算逻辑，很多计算逻辑
    }
}
