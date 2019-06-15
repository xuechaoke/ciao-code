package ciao.code.spring.example.demo03stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @program: ciao-code
 * @author: xuechaoke
 * @description: Stream的转换
 * @create: 2019-06-13 14:30
 **/

public class Test02 {
    public static void main(String[] args) {
        test();

    }

    public static void test() {
        // 流与数组的转换
        Stream stream = Stream.of("abc", "def");
        String[] array = (String[]) stream.toArray(String[]::new);
        for (String s : array) {
            System.out.println(s);
        }


        // 流转集合
        List<String> list = Stream.of("1", "2", "3").collect(Collectors.toList());


        String str = String.join("", "abc", "mn");
        list.forEach(System.out::println);
        System.out.println(str);
    }
}
