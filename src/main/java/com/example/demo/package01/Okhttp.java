package com.example.demo.package01;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @program: demo_okhttp
 * @description:
 * @author: xiebinbin
 * @create: 2022-10-29 13:57
 **/

public class Okhttp {
    public static void main(String[] args) {
        String url = "https://www.csdn.net";
        // 创建okHttpClient
        OkHttpClient okHttpClient = new OkHttpClient();
        // 构建request
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        try {
            // 使用okHttpClient发送请求，返回一个响应
            Response response = okHttpClient.newCall(request).execute();
            System.out.println(response.code());
            System.out.println(response.headers());
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
