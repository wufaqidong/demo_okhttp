package com.example.demo.package02;

import com.alibaba.fastjson.JSONObject;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.testng.Assert;


import java.io.IOException;

/**
 * @program: demo_okhttp
 * @description:
 * @author: xiebinbin
 * @create: 2022-10-29 14:08
 **/

public class Okhttp2 {
    public static void main(String[] args) throws IOException {
        String url = "https://coolapi.coolcollege.cn/platform-api/chooseEnterprise";
        // 创建okHttpClient对象
        OkHttpClient okHttpClient = new OkHttpClient();
        // 创建RequestBody
//        MediaType type = MediaType.parse("application/x-www-from-urlencoded");
//        RequestBody body = RequestBody.create(type,"username=admin&password=admin123");
//        Request request = new Request.Builder().url(url).post(body).build();
        FormBody body = new FormBody.Builder()
                .add("enterpriseId", "1539814809141383182")
                .add("isMultiterminal", "true")
                .add("user_id", "1800819662242582528")
                .build();
        Request request = new Request.Builder()
                .url(url)
                .addHeader("X-Access-Token", "922152758acb4afcaf1b4d11ffc97ce6")
                .post(body)
                .build();

        Response response = okHttpClient.newCall(request).execute();
        System.out.println("11" + response.code());
        System.out.println("22" + response.headers());

        okHttpClient.newCall(request).execute();

        JSONObject jsonObject = JSONObject.parseObject(response.body().string());
        System.out.println("44" + jsonObject);
        String jo = jsonObject.getString("data");
        JSONObject jsonObject1 = JSONObject.parseObject(jo);
        String user = jsonObject1.getString("user");
        JSONObject jsonObject2 = JSONObject.parseObject(user);
        String enterpriseId1 = jsonObject2.getString("enterpriseId");
        System.out.println("55" + jo);
        System.out.println("66" + user);
        System.out.println("77" + enterpriseId1);
        Assert.assertEquals(enterpriseId1, "1539814809141383182", "接口成功");
        System.out.println("88" + enterpriseId1);
    }

}
