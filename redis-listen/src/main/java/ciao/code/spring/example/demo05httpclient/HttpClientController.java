package ciao.code.spring.example.demo05httpclient;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.web.bind.annotation.*;

/**
 * @program: ciao-code
 * @author: xuechaoke
 * @description: Http Client Controller
 * @create: 2019-06-17 10:23
 **/
@RestController
@RequestMapping("/http")
public class HttpClientController {
    @PostMapping("/testJson")
    public String testJson(@RequestBody JSONObject jsonObject) {
        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");

        return "testJson:" + username + "=====" + password;

    }

    @PostMapping("/testForm")
    public String testForm(@RequestHeader("token") String header,
                           @CookieValue("username") String usernamecookie,

                           String username, String password) {

        return "testForm:" + username + " " + password
                + "token:" + header + "  cookie: username=" + usernamecookie;

    }


    @GetMapping("/student/{name}/{age}")
    public Student getStudent(@PathVariable("name") String name,
                              @PathVariable("age") Integer age) {
        return new Student(name, age);
    }

}
