package com.fancv.lamda.anonymousFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * lambda 方法引用
 * ::
 */
public class methodReferences {
    public static void main(String args[]) {
        List<String> names = new ArrayList();
        String[] arrayb;
        names.add("Google");
        names.add("Runoob");
        names.add("Taobao");
        names.add("Baidu");
        names.add("Sina");
        names.add("");
        names.forEach(System.out::println);
        Stream.of(names).filter((f) -> f.isEmpty());
        arrayb = names.stream().filter((f) -> f.length()>4).toArray(String[]::new);
        System.out.println(arrayb.length);
    }
}
