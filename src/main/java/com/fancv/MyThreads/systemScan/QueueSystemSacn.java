package com.fancv.MyThreads.systemScan;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.SneakyThrows;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class QueueSystemSacn {


    public static Deque<File> dqFile = new LinkedBlockingDeque<>();
    public static Deque<File> dqFile2 = new LinkedBlockingDeque<>();
    public static Deque<File> dqFloder = new LinkedBlockingDeque<>();
    public static AtomicInteger a = new AtomicInteger(0);


    static class ScanRunnable implements Runnable {
        Deque<File> dqFile = new LinkedBlockingDeque<>();
        private CyclicBarrier cyclicBarrier;

        public ScanRunnable(Deque<File> dqFile, CyclicBarrier cyclicBarrier) {
            this.dqFile = dqFile;
            this.cyclicBarrier = cyclicBarrier;
        }

        @SneakyThrows
        @Override
        public void run() {
            while (true) {
                if (!dqFile.isEmpty()) {
                    File firstF = dqFile.pollFirst();
                    fileParser(firstF);
                    dqFile2.add(firstF);
                } else {
                    Thread.sleep(1000);
                    cyclicBarrier.await();
                    System.out.println("线程名称：" + Thread.currentThread().getName());
                    System.out.println("已经扫描文件数：" + dqFile2.size());
                    a.getAndIncrement();

                    Thread.currentThread().stop();
                    break;
                }
            }
            System.out.println("动用线程数:" + a);
        }
    }


    /**
     * 时间戳转换成日期格式字符串
     *
     * @param seconds
     * @return
     */
    public static String timeStamp2Date(Long seconds) {
        if (seconds == null) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date(seconds));
    }


    public static void fileParser(File innerFile) {
        if (innerFile.isDirectory()) {
            dqFloder.add(innerFile);
            Optional<File[]> assOP = Optional.ofNullable(innerFile.listFiles());
            if (assOP.isPresent()) {
                List<File> StringList = Arrays.asList(innerFile.listFiles());
                dqFile.addAll(StringList);
            } else {
                System.out.println("文件为空 名称信息：" + innerFile.getName());
            }
        } else {
            /**
             * 筛选出符合条件的文件
             */
            System.out.println("文件路径：" + innerFile.getAbsolutePath() +
                    "\n 文件大小：" + innerFile.length() / 1024 + " kb  \n 文件最后修改时间：" + timeStamp2Date(innerFile.lastModified()));

        }


    }


    /**
     * 改为多线程逻辑
     * 1.每个线程打印一个文件夹中的文件
     * 2.如果是子文件夹 放到公共队列中
     * 3.每个线程是消费者
     *
     * @param args
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入扫描路径");
        String path = sc.nextLine();
        System.out.println("扫描路径:" + path);

        File f = new File(path);

        if (f.exists()) {
            System.out.println("路径存在：开始扫描");
            List<File> innerFileList = Collections.singletonList(f);
            dqFile.addAll(innerFileList);

        }

        //google 提供ThreadFactory 但是没有继承接口


        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();
        ExecutorService singleThreadPool = new ThreadPoolExecutor(12, 15,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
        int threadCount = 7;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(threadCount);
        for (int i = 0; i < threadCount; i++) {
            System.out.println("创建工作线程" + i);
            singleThreadPool.execute(new ScanRunnable(dqFile, cyclicBarrier));
        }


        singleThreadPool.shutdown();


        System.out.println("扫描结束！！！");

    }
    //TODO
    /**
     * 多线程扫描文件，
     * 一个线程扫描文件夹，把文件放入队列，文件夹放入队列
     * 这样两个队列分别扫描
     *
     */
}
