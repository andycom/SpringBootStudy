package com.fancv;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Java 多线程扫描程序
 * 按照文件大小、创建时间筛选文件 名称列表
 */
public class ScanSystem {

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
                Optional<File[]> assOP = Optional.ofNullable(file.listFiles());
                if (assOP.isPresent()) {
                    List<File> StringList = Arrays.asList(file.listFiles());
                    FileList.addAll(fileLists(StringList));
                } else {
                    System.out.println("文件为空 名称信息：" + file.getName());
                }
            } else {
                System.out.println("文件路径：" + file.getAbsolutePath());
                System.out.println("文件大小：" + file.getTotalSpace() / 1024 / 1024 + " mb");
                System.out.println("文件最后修改时间：" + timeStamp2Date(file.lastModified()));


                FileList.add(file);
            }
        }
        return FileList;
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
            List<File> result = fileLists(innerFileList);
            System.out.println("扫描结果：" + result.size());
        }


    }
}
