package com.example.demo.package02;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

/**
 * @program: demo_okhttp
 * @description:
 * @author: xiebinbin
 * @create: 2022-10-29 14:08
 **/

public class Okhttp2 {
    public static void main(String[] args) throws IOException {
        String url = "http://localhost/login?redirect=%2Findex";
        // 创建okHttpClient对象
        OkHttpClient okHttpClient = new OkHttpClient();
        // 创建RequestBody
        MediaType type = MediaType.parse("application/x-www-from-urlencoded");
        RequestBody body = RequestBody.create(type,"username=admin&password=admin123");
        Request request = new Request.Builder().url(url).post(body).build();

        Response response = okHttpClient.newCall(request).execute();
        System.out.println(response.code());
        System.out.println(response.headers());
        System.out.println(response.body().string());

    }
}
