package ciao.code.spring.example.demo05httpclient.resttemplate.get;

import ciao.code.spring.example.demo05httpclient.resttemplate.Student;
import cn.hutool.http.HttpRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
        String url = "https://reg.mail.163.com/unireg/call.do?cmd=urs.checkName";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/x-www-form-urlencoded; charset=UTF-8"));
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("name", "xck1995xck2008");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
        System.out.println(response.getBody());

    }


}
