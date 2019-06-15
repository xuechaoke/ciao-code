package ciao.code.spring.example.demo03stream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

/**
 * @program: ciao-code
 * @author: xuechaoke
 * @description: 流的构造方式
 * @create: 2019-06-13 14:30
 **/

public class Test01 {
    public void test() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        Stream<String> stringStream = Stream.of("1", "2", "3", "4", "5");

        String[] array = new String[]{"abc", "efg"};
        Stream<String> stringStream1 = Stream.of(array);

        // 集合子类即可 .stream() 获取流
        List<String> list = Arrays.asList(array);
        Stream<String> stringStream2 = list.stream();
        HashSet hashSet = new HashSet();
        Stream stream = hashSet.stream();
    }
}
