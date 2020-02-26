package lessons.java.lesson17.example2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        Stream<Integer> stream = integers.stream();
        stream.forEach(System.out::println);
        List<Integer> collect = stream.collect(Collectors.toList());
//        stream.forEach(System.out::println);

    }
}
