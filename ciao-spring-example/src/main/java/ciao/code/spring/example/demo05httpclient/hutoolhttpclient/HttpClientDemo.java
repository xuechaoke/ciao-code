package ciao.code.spring.example.demo05httpclient.hutoolhttpclient;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @program: ciao-code
 * @author: xuechaoke
 * @description: post跟get请求示例
 * @create: 2019-06-17 10:18
 **/
@Slf4j
public class HttpClientDemo {
    public static void main(String[] args) throws Exception {
        postForm();
    }

    public static void postForm() throws IOException {
        String body = HttpRequest.post("http://192.168.11.231:8099/ofmcloud112/v1/api/user/login")
                .form("username", "admin")
                .form("password", "admin")
                .timeout(20000)
                .execute().body();
        JSONObject jsonObject = JSON.parseObject(body);
        if (jsonObject.getLong("code") == 1) {
            String token = jsonObject.getJSONObject("data").getString("token");
            if (token != null) {
                FileInputStream fileInputStream = new FileInputStream("C:/Users/Administrator/Desktop/test.jpg");
            }
        }
    }

    public static void postJson() throws IOException {
        HttpRequest post = HttpRequest.post("http://localhost:8001/http/testJson");
        String body = post.body("{\"username\": \"ciao\",\"password\": \"123456\"}")
                .execute().body();
        log.info("body={}", body);
    }


    /**
     * 发送 get请求
     *
     * @throws Exception
     */
    public static void get() throws Exception {
        System.out.println(HttpRequest.get("http://baidu.com").execute().body());
    }
}
