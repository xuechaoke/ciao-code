package ciao.code.spring.example.demo03stream;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @program: ciao-code
 * @author: xuechaoke
 * @description:
 * @create: 2019-06-13 15:40
 **/
@Data
@AllArgsConstructor
public class Dish {
    private  String name;
    private  boolean vegetarian;
    private  int calories;
    private  Type type;
    public enum Type { MEAT, FISH, OTHER }
}
