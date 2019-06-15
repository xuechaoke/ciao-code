package ciao.code.spring.example.demo04redis.redis.listener;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

/**
 * @program: ofm1000
 * @author: xuechaoke
 * @description: 接收消息
 * @create: 2018-12-27 09:52
 **/

//@Component("receiver2")
@Slf4j
@AllArgsConstructor
public class Receiver2 implements MessageListener {
    private final StringRedisTemplate stringRedisTemplate;

    @Override
    public void onMessage(Message message, byte[] bytes) {
        RedisSerializer<String> valueSerializer = stringRedisTemplate.getStringSerializer();
        String deserialize = valueSerializer.deserialize(message.getBody());
        log.info("receiver2收到的mq消息" + deserialize);

    }
}
