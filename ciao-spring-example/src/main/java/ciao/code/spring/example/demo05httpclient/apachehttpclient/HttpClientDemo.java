package ciao.code.spring.example.demo05httpclient.apachehttpclient;

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
import org.apache.http.protocol.HTTP;
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

public class HttpClientDemo {
    public static void main(String[] args) throws Exception {
        get();
    }

    public static void postJson() throws IOException {
        CloseableHttpClient closeableHttpClient = null;
        CloseableHttpResponse closeableHttpResponse = null;

        try {
            closeableHttpClient = HttpClients.createDefault();
            String url = "http://localhost:8001/http/testForm";
            HttpPost httpPost = new HttpPost(url);
            String json = "{\"test\":\"456432132\"}";
            StringEntity se = new StringEntity(json);
            se.setContentType("UTF-8");
            //发送json需要设置contentType
            se.setContentType("application/json");
            httpPost.setEntity(se);
            closeableHttpResponse = closeableHttpClient.execute(httpPost);
            //解析返结果
            HttpEntity entity = closeableHttpResponse.getEntity();
            if (entity != null) {
                String resStr = EntityUtils.toString(entity, "UTF-8");
                System.out.println(resStr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeableHttpClient.close();
            closeableHttpResponse.close();
        }
    }

    public static void postForm() throws IOException{
        // 创建默认的httpClient实例.
        CloseableHttpClient httpclient = null;
        //发送请求
        CloseableHttpResponse response = null;
        try {
            httpclient = HttpClients.createDefault();
            // 创建httppost
            String url= "http://localhost:8001/http/testForm";
            HttpPost httppost = new HttpPost(url);
            httppost.setHeader("token","987654321");
            // 创建参数队列
            List<NameValuePair> formparams = new ArrayList<NameValuePair>();
            formparams.add(new BasicNameValuePair("username", "admin"));
            formparams.add(new BasicNameValuePair("password", "123456"));
            //参数转码
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
            httppost.setEntity(uefEntity);
            response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                System.out.println(EntityUtils.toString(entity, "UTF-8"));
            }
            //释放连接
        } catch (Exception e) {
           e.printStackTrace();
        }finally{
            httpclient.close();
            response.close();
        }
    }


    /**
     * 发送 get请求
     * @throws Exception
     */
    public static void get() throws Exception {
        CloseableHttpClient httpclient = null;
        CloseableHttpResponse response = null;
        try {
            httpclient = HttpClients.createDefault();
            // 创建httpget.
            HttpGet httpget = new HttpGet("http://www.baidu.com/");
            // 执行get请求.
            response = httpclient.execute(httpget);
            // 获取响应实体
            HttpEntity entity = response.getEntity();

            // 打印响应状态
            System.out.println(response.getStatusLine().getStatusCode());
            if (entity != null) {
                // 打印响应内容
                System.out.println("Response content: " + EntityUtils.toString(entity));
            }
        } catch (Exception e) {
            throw e;
        }finally{
            httpclient.close();
            response.close();
        }
    }
}
