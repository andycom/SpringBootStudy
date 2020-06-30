package com.fancv.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @Author hamish-wu
 * @create 2020/6/30 15:25
 * @Description
 */
@RestController
@RequestMapping("assert")
@Api("1.assert")
public class AssentController {

    @GetMapping("/num")
    @ApiOperation("数字断言判断")
    public String number(Integer a) {
        assert a >= 0;
        boolean isSafe = true;
        assert isSafe;
        System.out.println("断言通过!");
        return "ok";
    }
}
