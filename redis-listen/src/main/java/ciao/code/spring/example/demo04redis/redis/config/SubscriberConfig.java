package ciao.code.spring.example.demo04redis.redis.config;

import ciao.code.spring.example.demo04redis.redis.listener.Receiver;
import ciao.code.spring.example.demo04redis.redis.listener.Receiver2;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

/**
 * @program: ofm1000
 * @author: xuechaoke
 * @description: 消息订阅者配置类
 * @create: 2018-12-27 09:55
 **/
@Configuration
@AllArgsConstructor
public class SubscriberConfig {


    @Bean
    public RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
                                                   MessageListenerAdapter listenerAdapter1,
                                                   MessageListenerAdapter listenerAdapter2) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(listenerAdapter1, new PatternTopic("receiver1"));
        container.addMessageListener(listenerAdapter2, new PatternTopic("receiver2"));
        return container;

    }

    @Bean
    public MessageListenerAdapter listenerAdapter1(Receiver receiver1) {
        //指定Receiver为代理接收类,接收消息方法为receiveMessage
        return new MessageListenerAdapter(receiver1);
    } @Bean
    public MessageListenerAdapter listenerAdapter2(Receiver2 receiver2) {
        //指定Receiver为代理接收类,接收消息方法为receiveMessage
        return new MessageListenerAdapter(receiver2);
    }



}
