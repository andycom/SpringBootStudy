package com.fancv.collection;

import java.util.*;

/**
 * @version 1.0
 * @Author hamish-wu
 * @create 2020/8/11 8:57
 * @Description
 */
public class MyVector {


    public static void main(String args[]) {
        List myVector = new Vector<>(10);
        myVector.add("1dad");
        myVector.add("23");

        Iterator<String> myi = myVector.iterator();

        while (myi.hasNext()) {
            System.out.println(myi.next());
        }

        List list = Collections.synchronizedList(new ArrayList());

    }
}
