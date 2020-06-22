/*
 *  Copyright(c)2002-2020,  www.fancv.com
 *  项目名称:SpringBootStudy   SpringBootStudy
 *  文件名称:PrintString.java
 *  Date:20-6-22 下午9:21
 *  Author: xixin
 */

package com.fancv.AnnotationDemo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface PrintString {

    String name() default "";
}
