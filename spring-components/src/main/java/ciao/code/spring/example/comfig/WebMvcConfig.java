package ciao.code.spring.example.comfig;

import ciao.code.spring.example.handlermethodargumentresolver.MyArgumentsResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @program: ciao-code
 * @author: xuechaoke
 * @description:
 * @create: 2019-06-21 11:57
 **/
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new MyArgumentsResolver());
    }
}
