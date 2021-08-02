/*
 *  Copyright(c)2002-2021,  www.fancv.com
 *  项目名称:SpringBootStudy   SpringBootStudy
 *  文件名称:WuClassLoader.java
 *  Date:2021/8/1 下午2:19
 *  Author: xixin
 */

package com.fancv.ClassLoader;

import com.fancv.file.FileUtil;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WuClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) {
        String myPath = "file:///Users/allen/Desktop/" + name.replace(".","/") + ".class";
        String local="classpath:/cl/CPUPrint.file";
        URL xmlpath = this.getClass().getClassLoader().getResource("file/CPUPrint.file");
        System.out.println(System.getProperty("user.dir"));
        System.out.println(local);
        byte[] cLassBytes = null;
        Path path = null;

        String path2 = System.getProperty("user.dir");
        String springtxt2 = path2 + File.separator + "file" + File.separator;
        String fileName = "MyTestDemo";
        File f = new File(springtxt2 + fileName);
        try {
            path = Paths.get(f.toURI());
            cLassBytes = Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Class clazz = defineClass(name, cLassBytes, 0, cLassBytes.length);
        return clazz;
    }

}
