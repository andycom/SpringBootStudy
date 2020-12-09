package com.fancv.nio;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.FutureRequestExecutionService;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.HttpRequestFutureTask;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @version 1.0
 * @Author hamish-wu
 * @create 2020/12/9 16:20
 * @Description
 */
public class HttpClientFeature {
    // 1.创建线程池
    private static ExecutorService executorService = Executors.newFixedThreadPool(5);

    // 2.创建http回调函数
    private static final class OkidokiHandler implements ResponseHandler<String> {


        @Override
        public String handleResponse(org.apache.http.HttpResponse httpResponse) throws ClientProtocolException, IOException {
            // 2.1处理响应结果
            return EntityUtils.toString(httpResponse.getEntity());
        }

    }

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        // 3.创建httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();

        // 4.创建FutureRequestExecutionService实例
        FutureRequestExecutionService futureRequestExecutionService = new FutureRequestExecutionService(httpclient,
                executorService);

        // 5.发起调用
        try {
            // 5.1请求参数
            HttpGet httpget1 = new HttpGet("https://zhuanlan.zhihu.com/p/61423830");
            HttpGet httpget2 = new HttpGet("https://zhuanlan.zhihu.com/p/61423830");
            // 5.2发起请求，不阻塞，马上返回
            HttpRequestFutureTask<String> task1 = futureRequestExecutionService.execute(httpget1,
                    HttpClientContext.create(), new OkidokiHandler());

            HttpRequestFutureTask<String> task2 = futureRequestExecutionService.execute(httpget2,
                    HttpClientContext.create(), new OkidokiHandler());

            // 5.3 do somthing

            // 5.4阻塞获取结果
            String str1 = task1.get();
            String str2 = task2.get();
            System.out.println("response:" + str1 + " " + str2);
        } finally {
            httpclient.close();
        }
    }
}
