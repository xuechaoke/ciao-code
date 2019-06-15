package ciao.code.spring.example.demo01springevent.listen;

import ciao.code.spring.example.demo01springevent.event.WakeupEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @program: ciao-code
 * @author: xuechaoke
 * @description: 实现ApplicationListener接口时需要将监听事件作为泛型传递
 * @create: 2019-06-13 11:38
 **/
@Component
public class StopApplicationListener implements ApplicationListener<WakeupEvent> {

    @Override
    public void onApplicationEvent(WakeupEvent event) {
        System.out.println("ApplicationListener方式监听到神秘代码:"+event.getCode());
    }
}
