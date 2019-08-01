package ciao.code.spring.example.demo05httpclient.resttemplate.get;

import ciao.code.spring.example.demo05httpclient.hutoolhttpclient.Pt100Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @program: ciao-code
 * @author: xuechaoke
 * @description: post跟get请求示例
 * @create: 2019-06-17 10:18
 **/
@Slf4j
public class GetForObjectDemo {
    public static void main(String[] args) throws Exception {
        postForm();
    }

    public static void postForm() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://192.168.11.231:8099/ofmcloud112/v1/api/user/login";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/x-www-form-urlencoded; charset=UTF-8"));
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("username", "admin");
        map.add("password", "admin");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        ResponseEntity<Pt100Result> response = restTemplate.postForEntity(url, request, Pt100Result.class);
        Pt100Result body = response.getBody();
        System.out.println(body);

    }


}
