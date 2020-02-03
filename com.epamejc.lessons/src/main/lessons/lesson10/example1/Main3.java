package main.lessons.lesson10.example1;

import lombok.SneakyThrows;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main3 {

    public static void main(String[] args) {
        List<Integer> collect =
                Stream.of(1, 2, 3)
                        .map(value -> IncrementX2(value))
                        .collect(Collectors.toList());

        List<Integer> collect2 =
                Stream.of(1, 2, 3)
                        .map(value -> {
                            try {
                                return IncrementX22(value);
                            } catch (Exception e) {
                                e.printStackTrace();
                                return 0;
                            }
                        })
                        .collect(Collectors.toList());


        List<Integer> collect3 =
                Stream.of(1, 2, 3)
                        .map(value -> IncrementX22(value))
                        .collect(Collectors.toList());

//        for (Integer integer : collect) {
//            System.out.println(integer);
//        }

        collect.forEach(System.out::println);


    }

    private static Integer IncrementX2(Integer value) {
        return value * 2;
    }


    @SneakyThrows
    private static Integer IncrementX22(Integer value) {
        return value * 22;
    }

}
