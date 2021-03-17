/*
 *  Copyright(c)2002-2021,  www.fancv.com
 *  项目名称:SpringBootStudy   SpringBootStudy
 *  文件名称:UserBO.java
 *  Date:21-2-17 上午11:12
 *  Author: xixin
 */

package com.fancv.DTO;

import lombok.Data;

@Data
public class UserBO {

    public UserBO(String userName, String password, String age) {
        this.userName = userName;
        this.password = password;
        this.age = age;
    }

    private String userName;

    private String password;

    private String age;
}
