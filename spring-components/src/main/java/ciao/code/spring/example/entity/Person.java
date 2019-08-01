package ciao.code.spring.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: ciao-code
 * @author: xuechaoke
 * @description:
 * @create: 2019-06-21 11:03
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String name;
    private Integer age;

}
