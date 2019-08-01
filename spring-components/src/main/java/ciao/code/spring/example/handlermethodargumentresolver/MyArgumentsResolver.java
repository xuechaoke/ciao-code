package ciao.code.spring.example.handlermethodargumentresolver;

import ciao.code.spring.example.annotation.MyRequestParam;
import ciao.code.spring.example.entity.Person;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @program: ciao-code
 * @author: xuechaoke
 * @description: 自定义参数解析器
 * @create: 2019-06-21 10:49
 **/

public class MyArgumentsResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(Person.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String name = webRequest.getParameter("name");
        Integer age = Integer.parseInt(webRequest.getParameter("age"));
        return new Person(name, age);
    }
}
