package com.fancv.controller;

import com.fancv.AnnotationDemo.PrintString;
import com.fancv.DTO.TestVo;
import io.micrometer.core.instrument.util.JsonUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @version 1.0
 * @Author hamish-wu
 * @create 2020/6/10 10:53
 * @Description
 */
@RestController
@RequestMapping("first")
public class FirstController {

    @PostMapping("test")
    @ApiOperation("测试")
    String test(@PrintString(name = "p") @RequestParam String a, @PrintString(name = "p") @RequestBody TestVo t) {

        System.out.println(a);
        System.out.println(JsonUtils.prettyPrint(a));
        System.out.println(JsonUtils.prettyPrint(t.toString()));


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
