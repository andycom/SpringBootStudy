/*
 *  Copyright(c)2002-2021,  www.fancv.com
 *  项目名称:SpringBootStudy   SpringBootStudy
 *  文件名称:NotNullController.java
 *  Date:21-2-17 上午11:11
 *  Author: xixin
 */

package com.fancv.controller;

import com.fancv.DTO.UserBO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 *
 */
@RestController
@RequestMapping("notNull")
public class NotNullController {


    @PostMapping("12")
    public String test(@RequestBody UserBO userBO) {


        //判断为空并重新生成对象
        UserBO s = Optional.ofNullable(userBO).orElse(new UserBO("1", "2", "3"));

        String newAge = Optional.ofNullable(userBO).map(userBO1 -> userBO1.getAge()).orElse("3");
        /**
         * 对于Optional的map和flatmap：
         * map是把结果自动封装成一个Optional，但是flatmap需要你自己去封装。
         */
        String password = Optional.ofNullable(userBO).flatMap(userBO2 -> Optional.ofNullable(userBO2.getPassword())).orElse("password");
        System.out.println(newAge + password);

        return "ok";
    }

}
