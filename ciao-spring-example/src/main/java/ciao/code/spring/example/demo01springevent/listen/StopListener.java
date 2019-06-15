package ciao.code.spring.example.demo01springevent.listen;/*
 * @Author:xuechaoke
 * @Description:
 * @Date: Created in 16:35 2019/6/12/012
 * @Modified By:
 */

import ciao.code.spring.example.demo01springevent.event.WakeupEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @program: ciao-code
 * @author: xuechaoke
 * @description:
 * @create: 2019-06-12 16:35
 **/
@Component
public class StopListener {

    @EventListener(WakeupEvent.class)
    public void stop(WakeupEvent wakeupEvent){
        System.out.println("监听到WakeupEvent事件的神秘代码:"+wakeupEvent.getCode());
    }
}
