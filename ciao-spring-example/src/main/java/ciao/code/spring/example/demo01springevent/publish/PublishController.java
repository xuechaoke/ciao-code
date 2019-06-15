package ciao.code.spring.example.demo01springevent.publish;/*
 * @Author:xuechaoke
 * @Description:
 * @Date: Created in 16:31 2019/6/12/012
 * @Modified By:
 */

import ciao.code.spring.example.demo01springevent.event.WakeupEvent;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: ciao-code
 * @author: xuechaoke
 * @description:
 * @create: 2019-06-12 16:31
 **/
@RestController
@AllArgsConstructor
public class PublishController {
    private final ApplicationEventPublisher applicationEventPublisher;

    @GetMapping("/publish/{code}")
    public String publish(@PathVariable("code") String code){
        applicationEventPublisher.publishEvent(new WakeupEvent(this,code));
        return "success";
    }
}
