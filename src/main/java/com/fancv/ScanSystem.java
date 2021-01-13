package com.fancv;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;

/**
 * Java 多线程扫描程序
 * 按照文件大小、创建时间筛选文件 名称列表
 */
public class ScanSystem {


    public static List<File> MyfileList = new CopyOnWriteArrayList<File>();

    public static List<File> MyFloder = new CopyOnWriteArrayList<>();

    public static Deque<File> dqFile = new LinkedBlockingDeque<>();
    public static Deque<File> dqFile2 = new LinkedBlockingDeque<>();
    public static Deque<File> dqFloder = new LinkedBlockingDeque<>();


    static class ScanRunnable implements Runnable {
        Deque<File> dqFile = new LinkedBlockingDeque<>();

        public ScanRunnable(Deque<File> dqFile) {
            this.dqFile = dqFile;
        }

        @Override
        public void run() {
            while (Boolean.TRUE) {
                if (!dqFile.isEmpty()) {
                    File firstF = dqFile.pollFirst();
                    fileParser(firstF);
                    dqFile2.add(firstF);
                } else {
                    Thread.yield();
                    dqFile2.size();
                    System.out.println("已经扫描文件数：" + dqFile2.size());
                }
            }
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


    public static List<File> fileLists(List<File> innerFileList) {
        List<File> FileList = new ArrayList<>(8);
        for (File file : innerFileList) {
            if (file.isDirectory()) {
                dqFloder.add(file);
                Optional<File[]> assOP = Optional.ofNullable(file.listFiles());
                if (assOP.isPresent()) {
                    List<File> StringList = Arrays.asList(file.listFiles());
                    FileList.addAll(fileLists(StringList));
                } else {
                    System.out.println("文件为空 名称信息：" + file.getName());
                }
            } else {
                MyfileList.add(file);
                System.out.println("文件路径：" + file.getAbsolutePath());
                System.out.println("文件大小：" + file.getTotalSpace() / 1024 / 1024 + " mb");
                System.out.println("文件最后修改时间：" + timeStamp2Date(file.lastModified()));
                dqFile.add(file);
            }
        }
        return FileList;
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

        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();
        ExecutorService singleThreadPool = new ThreadPoolExecutor(8, 8,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        singleThreadPool.execute(new ScanRunnable(dqFile));
        singleThreadPool.execute(new ScanRunnable(dqFile));
        singleThreadPool.execute(new ScanRunnable(dqFile));
        singleThreadPool.execute(new ScanRunnable(dqFile));
        singleThreadPool.execute(new ScanRunnable(dqFile));
        singleThreadPool.execute(new ScanRunnable(dqFile));
        singleThreadPool.execute(new ScanRunnable(dqFile));
        singleThreadPool.execute(new ScanRunnable(dqFile));

        singleThreadPool.shutdown();


    }
    //TODO
    /**
     * 多线程扫描文件，
     * 一个线程扫描文件夹，把文件放入队列，文件夹放入队列
     * 这样两个队列分别扫描
     *
     */
}
