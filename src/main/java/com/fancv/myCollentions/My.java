package com.fancv.myCollentions;

import java.util.HashMap;

public class My {
    static final void intToTwo(int num) {
        String twoInt = "";
        for (int i = num; i != 0; i = i / 2) {
            if (i % 2 == 0) {
                twoInt = "0" + twoInt;
            } else {
                twoInt = "1" + twoInt;
            }
        }
        System.out.println(twoInt);
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n + 1;
    }

    public static void main(String[] args) {
        int cap = 1000;
        int[] probability1 = new int[cap];

        int[] probability2 = new int[cap];
        for (int ic = 0; ic < cap; ic++) {
            System.out.println("---------------");
            int hashLong = ("fanglile" + ic).hashCode();
            System.out.print(hashLong);
            System.out.print("  ");
            System.out.print((probability1[ic] = hashLong & (tableSizeFor(cap) - 1)));
            System.out.print("  ");
            intToTwo(hashLong);
            hashLong ^= hashLong >>> 16;
            System.out.print(hashLong);
            System.out.print("  ");
            System.out.print((probability2[ic] = hashLong & (tableSizeFor(cap) - 1)));
            System.out.print("  ");
            intToTwo(hashLong);
        }
        HashMap<Integer, Integer> map1 = new HashMap<>();
        for (int ic = 0; ic < probability1.length; ic++) {
            map1.put(probability1[ic], map1.containsKey(probability1[ic]) ? map1.get(probability1[ic]) + 1 : 1);
        }
        for (java.util.Map.Entry<Integer, Integer> e : map1.entrySet()) {
            System.out.println(e.getKey() + " 出现次数是:" + e.getValue());
        }
        System.out.println(map1.size());
        System.out.println("----------分割----------");
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int ic = 0; ic < probability2.length; ic++) {
            map2.put(probability2[ic], map2.containsKey(probability2[ic]) ? map2.get(probability2[ic]) + 1 : 1);
        }
        for (java.util.Map.Entry<Integer, Integer> e : map2.entrySet()) {
            System.out.println(e.getKey() + " 出现次数是:" + e.getValue());
        }
        System.out.println(map2.size());
    }
}
