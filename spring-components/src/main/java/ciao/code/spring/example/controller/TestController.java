package ciao.code.spring.example.controller;

import ciao.code.spring.example.annotation.MyRequestParam;
import ciao.code.spring.example.entity.Person;
import org.springframework.web.bind.annotation.*;

/**
 * @program: ciao-code
 * @author: xuechaoke
 * @description:
 * @create: 2019-06-21 11:02
 **/
@RestController
public class TestController {


    @GetMapping
    public Person test1(Person person){
        return person;
    }
}
