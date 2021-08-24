package com.fancv.controller;


import com.fancv.Service.GeneralService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 构造器注入
 */
@RestController
@RequestMapping("auto")
public class SecondController {


    private GeneralService generalService;


    public SecondController(GeneralService generalService) {
        this.generalService = generalService;
    }

    @GetMapping("a")
    public String hello() {
        return generalService.generalMethod();
    }
}
