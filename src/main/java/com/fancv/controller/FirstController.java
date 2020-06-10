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
}
