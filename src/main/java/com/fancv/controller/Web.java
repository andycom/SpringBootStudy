package com.fancv.controller;

import com.fancv.Service.A;
import com.fancv.Service.B;
import com.fancv.Service.MemoryOutService;
import com.fancv.compare.ApplicationContextProvider;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.*;

@Controller
@RequestMapping("test")
@Api(tags = "1.测试接口")
@Slf4j
@Validated
public class Web {

    /**
     * 校验日期正则
     */
    private final static String REGEXP = "([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8])))";


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

    @GetMapping("a")
    @ApiOperation("测试MVC GET 参数校验")
    @ResponseBody
    String testpararmer(@RequestParam("a") @Pattern(regexp = "[0-9]{11} ", message = "请输入正确的手机号码") String a, @NotBlank(message = "姓名不能为空") @RequestParam("name") String name, HttpServletRequest request) {
        // .....@NotNull(message = "name 不能为空") String name) {
        log.info(a);
        log.info(name);
        return a;
    }

    @PostMapping("t1")
    public Object t1(@NotNull(message = "用户名为空") @Length(max = 8, min = 5, message = "登入账号5~8位") String username,

                     @NotBlank(message = "密码为空") @Length(max = 8, min = 5, message = "密码长度5~8位") String password,

                     @Max(value = 99, message = "最大为99") @Min(value = 18, message = "最小为18") Integer age,

                     @Pattern(regexp = REGEXP, message = "日期格式yyyy-MM-dd") String date, HttpServletRequest request) {

        log.info("t1.ok");
        return request.getParameterMap();
    }


}
