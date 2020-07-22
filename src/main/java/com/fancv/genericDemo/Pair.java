package com.fancv.genericDemo;

/**
 * @version 1.0
 * @Author hamish-wu
 * @create 2020/7/1 9:42
 * @Description
 */
public class Pair<T> {

    T first;
    T second;

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }
}