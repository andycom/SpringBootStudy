package com.fancv.Service;

import com.fancv.DTO.TestVo;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * @version 1.0
 * @Author hamish-wu
 * @create 2020/8/19 14:19
 * @Description
 * jdk 11 参数
 * -Xms64m
 * -Xmx64m
 * -XX:+HeapDumpOnOutOfMemoryError
 * -XX:MetaspaceSize=64M
 * -XX:MaxMetaspaceSize=128M
 * -XX:+AlwaysPreTouch
 * -XX:ReservedCodeCacheSize=64m
 * -XX:InitialCodeCacheSize=64m
 * -Xss512k
 * -XX:+UseG1GC
 * -Xlog:gc*
 */
@Service
public class MemoryOutService {


    public void outTest() {
        List<TestVo> mylist = new LinkedList<>();
        while (Boolean.TRUE) {
            mylist.add(new TestVo());
        }
    }

}
