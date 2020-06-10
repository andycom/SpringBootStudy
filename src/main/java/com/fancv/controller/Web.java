package com.fancv.controller;

import com.fancv.Service.A;
import com.fancv.Service.B;
import com.fancv.compare.ApplicationContextProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("test")
public class Web {

    @Autowired
    ApplicationContextProvider applicationContextProvider;

    @GetMapping("1")
    String test() {


        A a = applicationContextProvider.getBean("a", A.class);
        B b = applicationContextProvider.getBean("b", B.class);

        return "hello";
    }
}
