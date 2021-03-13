package com.fancv.myCollentions;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @version 1.0
 * @Author hamish-wu
 * @create 2020/7/14 14:20
 * @Description
 */
public class MyLinkedList {

    public static void main(String args[]) {

        LinkedList<String> a = new LinkedList<String>();
        a.addFirst("A");
        a.addFirst("B");
        a.addFirst("C");
        a.addFirst("D");


        Iterator<String> ite = a.iterator();
        while (ite.hasNext()) {
            String s = (ite.next());
            if (s.equals("B")) {
                ite.remove();
            }
        }


        Collections.shuffle(a);


        System.out.println(a);
        Collections.sort(a);

        System.out.println(a);

    }
}

