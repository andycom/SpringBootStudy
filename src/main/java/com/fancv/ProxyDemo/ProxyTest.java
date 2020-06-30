package com.fancv.ProxyDemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

/**
 * @version 1.0
 * @Author hamish-wu
 * @create 2020/6/29 16:26
 * @Description
 */
public class ProxyTest {


    public static void main(String[] args) {
        Object[] elements = new Object[1000];

        // fill elements with proxies for the integers 1 ... 1000
        for (int i = 0; i < elements.length; i++) {
            Integer value = i + 1;
            InvocationHandler handler = new TraceHandler(value);
            Object proxy = Proxy.newProxyInstance(null, new Class[]{Comparable.class}, handler);


            elements[i] = proxy;
        }
        // construct a random integer
        Integer key = new Random().nextInt(elements.length) + 1;

        System.out.println("key:" + key);

        // search for the key
        int result = Arrays.binarySearch(elements, key);

        // print match if found
        if (result >= 0)
            System.out.println("print match if found: " + elements[result]);

        for (Object o : elements) {
            o.toString();
            System.out.println(o.getClass().getName());
        }

    }
}

/**
 * 38 * An invocation handler that prints out the method name and parameters, then
 * 39 * invokes the original method
 * 40
 */
class TraceHandler implements InvocationHandler {

    private Object target;

    /**
     * 46 * Constructs a TraceHandler
     * 47 * @param t the implicit parameter of the method call
     * 48
     */
    public TraceHandler(Object t) {
        target = t;
    }

    public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
        if (args != null) {
            for (Object od : args) {
                System.out.println("入参：" + od);
            }
        }
        // print implicit argument
        System.out.print(target);
        // print method name
        System.out.print("." + m.getName() + "(");
        // print explicit arguments
        if (args != null) {

            for (int i = 0; i < args.length; i++) {
                System.out.print(args[i]);
                if (i < args.length - 1) System.out.print(", ");
            }
        }
        System.out.println(")");
        // invoke actual method
        return m.invoke(target, args);


    }
}

