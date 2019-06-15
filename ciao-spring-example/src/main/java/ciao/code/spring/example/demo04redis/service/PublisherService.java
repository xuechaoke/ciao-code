package ciao.code.spring.example.demo04redis.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @program: ofm1000
 * @author: xuechaoke
 * @description: 消息生产者
 * @create: 2018-12-27 09:48
 **/

@Service
@AllArgsConstructor
public class PublisherService {
    private final StringRedisTemplate stringRedisTemplate;

    public String sendMessage(String name) {
        try {
            stringRedisTemplate.convertAndSend("receiver1", name);
            stringRedisTemplate.convertAndSend("receiver2", name);
            return "消息发送成功了";

        } catch (Exception e) {
            e.printStackTrace();
            return "消息发送失败了";
        }
    }

}
