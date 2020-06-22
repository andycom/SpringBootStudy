/*
 *  Copyright(c)2002-2020,  www.fancv.com
 *  项目名称:SpringBootStudy   SpringBootStudy
 *  文件名称:TestVo.java
 *  Date:20-6-27 下午12:15
 *  Author: xixin
 */

package com.fancv.DTO;

import com.fancv.AnnotationDemo.PrintString;
import com.fancv.AnnotationDemo.VoCheck;

public class TestVo extends CheckDto {

    @VoCheck(message = "名称: 必填", require = true)
    @PrintString(name = "p")
    private String test;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }


}
