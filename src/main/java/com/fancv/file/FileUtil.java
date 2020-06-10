package com.fancv.file;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class FileUtil {

    /**
     * 字符串编码转换的实现方法
     *
     * @param str        待转换编码的字符串
     * @param newCharset 目标编码
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String changeCharset(String str, String oldCharset,String newCharset)
            throws UnsupportedEncodingException {
        if (str != null) {
            //用默认字符编码解码字符串。
            byte[] bs = str.getBytes(oldCharset);
            //用新的字符编码生成字符串
            return new String(bs, newCharset);
        } else {
            return null;
        }
    }

    /**
     * 读取网络内容
     *
     * @param url
     * @return
     */
    private static String getStream(String url) {
        //获取字节流
        InputStream in = null;
        String result = "";
        try {
            in = new URL(url).openStream();
            int tmp;
            while ((tmp = in.read()) != -1) {
                result += (char) tmp;
            }
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 读取文件中内容
     */

    protected static void readtxt() {
        String path = System.getProperty("user.dir");
        String springtxt = path + File.separator + "file" + File.separator;
        String fileName = "spring.txt";
        File f = new File(springtxt + fileName);
        System.out.println("文件路径：" + f.getPath() + "\n文件是否存在：" + f.exists());

        try {
            InputStream input = new FileInputStream(f);

            byte b[] = new byte[(int) f.length()];        // 数组大小由文件决定
            int len = input.read(b);        // 读取内容
            // 第4步、关闭输出流
            input.close();                        // 关闭输出流\
            System.out.println("读入数据的长度：" + len);
            System.out.println("内容为：" + new String(b));    // 把byte数组变为字符串输出
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (final Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String args[]) {

        //0.读取TXT 内容
        // readtxt();

        //1.读取网络内容

        try {
            System.out.println(changeCharset(getStream("http://www.fancv.com"), "ISO8859-1","utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


}
