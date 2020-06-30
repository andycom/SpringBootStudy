package com.fancv.lamda;

import com.fancv.DTO.TestVo;

import java.util.Arrays;
import java.util.function.Supplier;

/**
 * @version 1.0
 * @Author hamish-wu
 * @create 2020/6/28 17:58
 * @Description
 */
public class firstLamda {

    public static void main(String args[]) {
        String[] planets = new String[]{"Mercury", "Venus", "Earth", "Mars",
                "Jupiter", "Saturn", "Uranus", "Neptune"};
        Arrays.sort(planets, (first, second) -> first.length() - second.length());
        //函数编程


        for (String temp : planets) {
            System.out.println(temp);
        }

        repeat(10, () -> System.out.println("Hello, World!"));


        TestVo testVo = new TestVo();

        testVo.setTest("sdfa");
        System.out.println(test_Supplier(() -> testVo));

        Integer[] data = new Integer[]{6, 5, 18, 3, 2, 1};
        int reslut = getMax(() -> {
            int max = 0;
            for (int i = 0; i < data.length; i++) {
                max = Math.max(max, data[i]);
            }
            return max;
        });
        System.out.println(reslut);

        Integer[] data2 = new Integer[]{6, 5, 18, 3, 2, 1};
        int reslut2 = getMax(() -> {
            int max = 0;
            for (int i = 0; i < data.length; i++) {
                max = Math.max(max, data[i]);
            }
            return max + 111;  //函数编程的返回实现 lamda 表达式作为入参传入函数式接口
        });
        System.out.println(reslut2);
    }


    public static void repeat(int n, Runnable action) {
        for (int i = 0; i < n; i++) action.run();
    }


    private static TestVo test_Supplier(Supplier<TestVo> suply) {
        return suply.get(); //供应者接口
    }


    private static int getMax(Supplier<Integer> suply) {
        return suply.get();
    }


}
