package com.fancv.MyLock;

import java.util.Arrays;

/**
 * @version 1.0
 * @Author hamish-wu
 * @create 2020/8/19 8:42
 * @Description
 */
public class MyTest {

    public static void main(String[] args) {
      /*  Object a = new Object();
        Object b = new Object();
        Thread a1 = new Thread(new print(a, b));
        Thread b1 = new Thread(new print(b, a));
        a1.start();
        b1.start();*/
        /*  System.out.println(isPalindrome(12321));*/
        /*System.out.println(Arrays.toString(twoSum(new int[]{3, 3, 4, 9}, 6)));*/
        /* System.out.println(reverse(-1534236469));*/
        /*   System.out.println(reverse(-563847412));*/
        System.out.println(Arrays.toString(plusOne(new int[]{9})));

    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int k = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (k == nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }


    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int i = 1;
        int m = x;
        while (m / 10 > 0) {
            m = m / 10;
            i++;
        }
        int nums[] = new int[i];
        int k = nums.length;
        for (int j = 0; j < k; j++) {
            if (x < 10) {
                nums[j] = x;
            } else {
                nums[j] = x % 10;
            }
            x = x / 10;

        }
        for (int j = 0; j < k - 1; j++) {
            if (nums[j] != nums[k - 1 - j]) {
                return false;
            }
        }
        return true;
    }

    public static int reverse(int x) {
        String s = Integer.toString(x);
        String y = new StringBuffer(s).reverse().toString();
        if (y.endsWith("-")) {
            y = y.substring(0, y.length() - 1);
            if (y.length() == 10 & y.compareTo("2147483647") > 0) {
                return 0;
            }
            int n = Integer.parseInt(y);
            n = ~n + 1;
            return n;
        } else if (y.length() == 10 & y.compareTo("2147483647") > 0) {
            return 0;
        } else {
            return Integer.parseInt(y);
        }


    }

    public static int[] plusOne(int[] digits) {
        int l = digits.length;
        digits[l - 1] = digits[l - 1] + 1;
        for (int i = digits.length; i > 0; i--) {

            if (digits[i - 1] == 10) {
                digits[i - 1] = 0;
                if (i - 2 >= 0) {
                    digits[i - 2] = digits[i - 2] + 1;
                } else {
                    int[] arr1 = new int[l + 1];
                    arr1[0] = 1;
                    int m = 1;
                    for (int i1 : digits) {
                        arr1[m] = i1;
                        m++;
                    }
                    return arr1;
                }
            }

        }
        return digits;
    }


}

class print implements Runnable {

    Object a;
    Object b;

    public print(Object a, Object b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        try {
            synchronized (a) {
                Thread.sleep(2000);
                System.out.println("A锁线程打印" + Thread.currentThread().getName());
                synchronized (b) {
                    System.out.println("B锁 线程打印" + Thread.currentThread().getName());
                }
            }
        } catch (Exception e) {

        }


    }
}
