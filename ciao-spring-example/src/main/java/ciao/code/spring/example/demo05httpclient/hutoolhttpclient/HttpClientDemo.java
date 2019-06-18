package ciao.code.spring.example.demo05httpclient.hutoolhttpclient;

import cn.hutool.http.HttpRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: ciao-code
 * @author: xuechaoke
 * @description: post跟get请求示例
 * @create: 2019-06-17 10:18
 **/
@Slf4j
public class HttpClientDemo {
    public static void main(String[] args) throws Exception {
        get();
    }

    public static void postForm() {
        String body = HttpRequest.post("http://localhost:8001/http/testForm")
                .cookie("username=xuechaoke")
                .header("token", "666")
                .form("username", "ciao")
                .form("password", "123456")
                .timeout(20000)
                .execute().body();

        log.info("body={}",body);

    }

    public static void postJson() throws IOException{
        HttpRequest post = HttpRequest.post("http://localhost:8001/http/testJson");
        String body = post.body("{\"username\": \"ciao\",\"password\": \"123456\"}")
                .execute().body();
        log.info("body={}",body);
    }


    /**
     * 发送 get请求
     * @throws Exception
     */
    public static void get() throws Exception {
        System.out.println(HttpRequest.get("http://baidu.com").execute().body());
    }
}
