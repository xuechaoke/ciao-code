package ciao.code.spring.example.demo04redis.controller;

import ciao.code.spring.example.demo04redis.service.PublisherService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: ciao-code
 * @author: xuechaoke
 * @description: redis  消息发布
 * @create: 2019-06-15 09:25
 **/
@RestController
@RequestMapping("/redis")
@AllArgsConstructor
public class RedisPublishController {
    private final PublisherService publisherService;

    @GetMapping("/publish/{message}")
    public String publish(@PathVariable("message") String message){
        publisherService.sendMessage(message);
        return "success";
    }

}
