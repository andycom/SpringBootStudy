/*
 *  Copyright(c)2002-2020,  www.fancv.com
 *  项目名称:SpringBootStudy   SpringBootStudy
 *  文件名称:VoCheck.java
 *  Date:20-6-27 下午12:06
 *  Author: xixin
 */

package com.fancv.AnnotationDemo;


import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Retention(RUNTIME)
@Target(FIELD)
public @interface VoCheck {
    String message() default ""; // 返回中文

    boolean require() default false; // 必填校验

}
