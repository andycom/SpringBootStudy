package com.fancv.ProxyDemo;

/**
 * @version 1.0
 * @Author hamish-wu
 * @create 2020/6/30 13:59
 * @Description
 */
public class AdminServiceImpl implements AdminService {
    public void update() {
        System.out.println("修改管理系统数据");
    }

    public Object find(String name) {
        System.out.println("查看管理系统数据"+name);
        return new Object();
    }

}