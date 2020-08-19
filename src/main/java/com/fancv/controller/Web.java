package com.fancv.controller;

import com.fancv.Service.A;
import com.fancv.Service.B;
import com.fancv.Service.MemoryOutService;
import com.fancv.compare.ApplicationContextProvider;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("test")
@Api(tags = "1.测试接口")
public class Web {

    @Autowired
    ApplicationContextProvider applicationContextProvider;

    @Autowired
    MemoryOutService memoryOutService;

    @GetMapping("1")
    String test() {


        A a = applicationContextProvider.getBean("a", A.class);
        B b = applicationContextProvider.getBean("b", B.class);

        return "hello";
    }


    @PostMapping("/out")
    @ApiOperation(value = "内存不足")
    String outMemory() {
        memoryOutService.outTest();
        return "ok";
    }

}
