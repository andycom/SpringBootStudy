package com.fancv.nio.callback;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.util.EntityUtils;

import java.io.IOException;


/**
 * @version 1.0
 * @Author hamish-wu
 * @create 2020/12/9 16:58
 * @Description
 */
public class MyCallback implements FutureCallback<HttpResponse> {

    public void failed(final Exception ex) {
        System.out.println(ex.getLocalizedMessage());
    }

    public void completed(final HttpResponse response) {
        try {
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cancelled() {
        System.out.println("cancelled");
    }
}