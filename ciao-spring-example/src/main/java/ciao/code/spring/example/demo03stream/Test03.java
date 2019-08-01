package ciao.code.spring.example.demo03stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @program: ciao-code
 * @author: xuechaoke
 * @description: 流的具体使用
 * @create: 2019-06-13 15:14
 **/

public class Test03 {
    public static void main(String[] args) {
        //test02();
        test01();
    }

    public static void test02() {
        ArrayList<String> words = new ArrayList<String>();
        words.add("Hello");
        words.add("World");
        Stream<String> stream = words.stream();
        stream.map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList()).forEach(System.out::println);

    }
    public static void test01() {
        List<Dish> menu = Arrays.asList(
               /* new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),*/
                new Dish("salmon1", false, 460, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));
        menu.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(dish->dish.getName()+dish.getCalories()+dish.getName()))),
                        ArrayList::new))
                .forEach(System.out::println);
       /* menu.stream()
                .filter(item -> item.getCalories() > 300)
                // 去重
                .distinct()
                .collect(toList()).forEach(System.out::println);*/


    }

}
