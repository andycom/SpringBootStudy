package com.fancv.lamda.anonymousFunction;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java8Lambda {

    /**
     * lambda 表达式作为匿名函数传入
     *
     * @param args
     */
    public static void main(String[] args) {
        new Thread(() -> System.out.println("lambda 表达式")).start();
        List<String> list = Arrays.asList("springboot", "springcloud", "redis", "git", "netty", "java", "html", "docker");
        List<String> resultList = list.stream().filter(obj -> obj.length() > 5).collect(Collectors.toList());
        System.out.println(resultList);








    }

}
