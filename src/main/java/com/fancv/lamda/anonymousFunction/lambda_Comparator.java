package com.fancv.lamda.anonymousFunction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class lambda_Comparator {

    //下面给出 lambda 以及实际替代的内部类写法
    private static Comparator<String> newComparator() {
        return (a, b) -> b.length() - a.length();
    }

    private static Comparator<String> newComparator_1() {
        return new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.length() - a.length();
            }
        };
    }

    public static void main(String[] args) {
        String[] array = {"abc", "ab", "abcd"};
        String[] arrayb;
        System.out.println(Arrays.toString(array));

        arrayb = Stream.of("2adbc", "1ab", "abcddd").toArray(String[]::new);
        System.out.println(Arrays.toString(arrayb));
        Arrays.sort(array, newComparator_1()); // 方式一
        Arrays.sort(array, (a, b) -> b.length() - a.length());//更简单的方式
        System.out.println(Arrays.toString(array));

    }
}
