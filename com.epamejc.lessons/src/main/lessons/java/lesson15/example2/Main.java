package lessons.java.lesson15.example2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
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

//        map(Function<? super T, ? extends R> mapper)
        // return "Number: 4"

        Function<Integer, String> function = new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return "Number: " + integer;
            }
        };

        Function<Integer, String> function2 = integer -> "Number: " + integer;

        Set<String> set = integers.stream()
                .map(integer -> "Number: " + integer)
                .collect(Collectors.toSet());

        set.forEach(string -> System.out.println(string));
        set.forEach(System.out::println);
    }
}
