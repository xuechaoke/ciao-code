package ciao.code.spring.example.demo01springevent.event;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * @program: ciao-code
 * @author: xuechaoke
 * @description:
 * @create: 2019-06-12 16:20
 **/
@Getter
public class WakeupEvent extends ApplicationEvent {

    private String code;
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public WakeupEvent(Object source,String code) {
        super(source);
        this.code = code;
    }
}
