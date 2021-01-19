package com.fancv.EventBusDemo;

import com.google.common.eventbus.Subscribe;

import javax.annotation.Resource;
import java.time.Instant;

/**
 * @author andy
 * @create 2020-12-31 13:40
 * @desc 事件监听
 **/

public class EventListener1 {

    @Resource


    @Subscribe
    public void test1(MessageEvent event) {
        System.out.println(Instant.now() + "监听者1-->订阅者1,收到事件：" + event.getMessage() + "，线程号为：" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Subscribe
    public void test2(MessageEvent event) {
        System.out.println(Instant.now() + "监听者1-->订阅者2,收到事件：" + event.getBusinessId() + "，线程号为：" + Thread.currentThread().getName());
    }
}