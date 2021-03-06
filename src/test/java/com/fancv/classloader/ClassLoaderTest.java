package com.fancv.classloader;

/**
 * @version 1.0
 * @Author hamish-wu
 * @create 2020/6/11 20:51
 * @Description
 */
public class ClassLoaderTest {

    public static void main(String[] args) {
        try {
            //查看当前系统类路径中包含的路径条目
            System.out.println(System.getProperty("java.class.path"));
            //调用加载当前类的类加载器（这里即为系统类加载器）加载TestBean
            Class typeLoaded = Class.forName("com.fancv.classloader.ClassLoaderTest");
            //查看被加载的TestBean类型是被那个类加载器加载的
            System.out.println(typeLoaded.getClassLoader());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
