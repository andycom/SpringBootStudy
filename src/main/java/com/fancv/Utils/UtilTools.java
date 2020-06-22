/*
 *  Copyright(c)2002-2020,  www.fancv.com
 *  项目名称:SpringBootStudy   SpringBootStudy
 *  文件名称:UtilTools.java
 *  Date:20-6-27 下午12:08
 *  Author: xixin
 */

package com.fancv.Utils;

import com.fancv.AnnotationDemo.PrintString;
import com.fancv.AnnotationDemo.VoCheck;
import com.fancv.DTO.CheckDto;
import io.micrometer.core.instrument.util.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UtilTools {

    public static void checkFiled(CheckDto dto) throws Exception, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Field[] fields = dto.getClass().getDeclaredFields();
        for (Field field : fields) {


            VoCheck annotation = field.getAnnotation(VoCheck.class);
            String name = StringUtils.isNotEmpty(annotation.message()) ? annotation.message() : field.getName();
            Method getMethod = dto.getClass().getDeclaredMethod("get" + UpfirstStr(field.getName()));

            Object v = getMethod.invoke(dto);
            String value = null == v ? null : String.valueOf(v);


            PrintString printString = field.getAnnotation(PrintString.class);
            if (printString.name().equals("p")) {
                System.out.println(value);
            }
            if (annotation.require()) {
                if (StringUtils.isEmpty(value)) {
                    throw new Exception(name + " 不可为空！");
                }
            }
        }
    }

    public static String UpfirstStr(String str) {

        char[] ch = str.toCharArray();
        String finalstr = "";

        for (int i = 0; i < ch.length; i++) {
            if (i == 0) {
                if (ch[i + 1] >= 96 && ch[i + 1] <= 122) {
                    ch[i] = (char) (ch[i] - 32);
                }
            } else if ((int) ch[i] == 32) {
                if ((ch[i] >= 96 && ch[i] <= 122)) {
                    ch[i + 1] = (char) ((int) ch[i + 1] - 32);
                }
            }
            finalstr = finalstr + ch[i];
        }
        return finalstr;

    }
}
