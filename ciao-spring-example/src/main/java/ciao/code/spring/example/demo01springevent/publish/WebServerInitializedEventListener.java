package ciao.code.spring.example.demo01springevent.publish;

import ciao.code.spring.example.demo01springevent.event.WakeupEvent;
import lombok.AllArgsConstructor;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @program: ciao-code
 * @author: xuechaoke
 * @description: 容器启动监听
 * @create: 2019-06-13 11:45
 **/
@Component
@AllArgsConstructor
public class WebServerInitializedEventListener {
    private final ApplicationEventPublisher applicationEventPublisher;

    @EventListener(WebServerInitializedEvent.class)
    public  void  publishEvent(){
        System.out.println("容器启动完成，发布事件");
        applicationEventPublisher.publishEvent(new WakeupEvent(this,"666"));
    }

}
