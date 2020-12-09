package com.fancv.nio;

import com.fancv.nio.callback.MyCallback;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 * @version 1.0
 * @Author hamish-wu
 * @create 2020/12/9 16:56
 * @Description
 */
public class snycHttpclient {
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        // 2.创建异步httpclient对象
        CloseableHttpAsyncClient httpclient = HttpAsyncClients.custom().build();

        // 3.发起调用
        try {

            // 3.0启动
            httpclient.start();
            // 3.1请求参数
            HttpGet httpget1 = new HttpGet("http://www.fancv.com");
            HttpGet httpget2 = new HttpGet("http://127.0.0.1:8080");
            // 3.2发起请求，不阻塞，马上返回
            httpclient.execute(httpget1, new MyCallback());
            httpclient.execute(httpget2, new MyCallback());

            System.out.println("不阻塞马上执行到这里了，看看结果 这个有用");
            // 3.3休眠10s,避免请求执行完成前，关闭了链接
            Thread.sleep(10000);
        } finally {
            httpclient.close();
        }
    }
}
