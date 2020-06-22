/*
 *  Copyright(c)2002-2020,  www.fancv.com
 *  项目名称:SpringBootStudy   SpringBootStudy
 *  文件名称:AnnotionTest.java
 *  Date:20-6-27 下午12:14
 *  Author: xixin
 */

package com.fancv.AnnotationDemo;

import com.fancv.DTO.TestVo;

import static com.fancv.Utils.UtilTools.checkFiled;

public class AnnotionTest {

    public static void main(String args[]) {

        TestVo testVo = new TestVo();
        testVo.setTest("sss");
        try {
            checkFiled(testVo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
