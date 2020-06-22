package com.fancv.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @Author hamish-wu
 * @create 2020/6/10 10:53
 * @Description
 */
@RestController
@RequestMapping("first")
public class FirstController {

    @GetMapping("test")
    String test() {
        return "ok";
    }


    @GetMapping("path")
    String getPath() {
        System.out.println(System.getProperty("sun.boot.library.path"));

        System.out.println(System.getProperty("java.ext.dirs"));

        //可以看到AppClassLoader加载的就是java.class.path下的路径。我们同样打印它的值。

        System.out.println(System.getProperty("java.class.path"));
        return null;
    }
}
