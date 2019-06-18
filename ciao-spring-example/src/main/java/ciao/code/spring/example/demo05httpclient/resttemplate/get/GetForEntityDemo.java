package ciao.code.spring.example.demo05httpclient.resttemplate.get;

import ciao.code.spring.example.demo05httpclient.resttemplate.Student;
import cn.hutool.http.HttpRequest;
import com.mysql.cj.protocol.x.Notice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public class GetForEntityDemo {
    public static void main(String[] args) throws Exception {
        get2();
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
     * 发带参数的get请求1
     * @throws Exception
     */
    public static void get() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Student> entity = restTemplate.getForEntity("http://fantj.top/notice/list/xuechaoke/25"
                , Student.class);

        HttpStatus statusCode = entity.getStatusCode();
        System.out.println("statusCode.is2xxSuccessful()"+statusCode.is2xxSuccessful());

        Student body = entity.getBody();
        System.out.println("entity.getBody()"+body);


        ResponseEntity.BodyBuilder status = ResponseEntity.status(statusCode);
        status.contentLength(100);
        status.body("我在这里添加一句话");
        ResponseEntity<Class<Student>> body1 = status.body(Student.class);
        Class<Student> body2 = body1.getBody();
        System.out.println("body1.toString()"+body1.toString());
    }

    /**
     * 发带参数的get请求
     * @throws Exception
     */
    public static void get2() {
        Map<String,String> map = new HashMap();
        map.put("name","薛超科");
        map.put("age","24");
        RestTemplate restTemplate = new RestTemplate();
        Student s = restTemplate.getForObject("http://localhost:8001/http/student/{name}/{age}", Student.class,map);
        System.out.println(s.toString());
    }


}
