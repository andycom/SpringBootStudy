package com.fancv.controller;

import com.fancv.EventBusDemo.EventBusUtil;
import com.fancv.EventBusDemo.EventListener1;
import com.fancv.EventBusDemo.MessageEvent;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping("message")
@Api("2.EventBus")
public class EventBusController {


    @GetMapping("1")
    public String postmessage(MessageEvent event) {
        EventListener1 listener1 = new EventListener1();

        EventBusUtil.register(listener1);

        EventBusUtil.post(event);
        EventBusUtil.asyncPost(event);
        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Instant.now() + ",主线程执行完毕：" + Thread.currentThread().getName());

        return "ok";
    }
}
