package com.fancv.classloader;

/**
 * @version 1.0
 * @Author hamish-wu
 * @create 2020/6/11 21:08
 * @Description
 */
public class classloaderpath {

    public static void main(String[] args) {
        try {

            System.out.println(System.getProperty("sun.boot.library.path"));

            System.out.println(System.getProperty("java.ext.dirs"));

            //可以看到AppClassLoader加载的就是java.class.path下的路径。我们同样打印它的值。

            System.out.println(System.getProperty("java.class.path"));

        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
}
