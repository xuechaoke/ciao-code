package ciao.code.spring.example.demo02springaop.controller;

import ciao.code.spring.example.demo02springaop.annotation.SysLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: ciao-code
 * @author: xuechaoke
 * @description: 测试
 * @create: 2019-06-13 12:11
 **/

@RestController
@RequestMapping("/aop")
public class TestController {
    @SysLog("调用/aop/test")
    @GetMapping("/test/{x}/{y}")
    public String test(@PathVariable("x") String x,@PathVariable("y") String y){
        return x+y;
    }
}
