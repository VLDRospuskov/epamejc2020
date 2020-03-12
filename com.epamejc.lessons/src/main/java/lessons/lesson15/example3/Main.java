package lessons.lesson15.example3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("barsik"));
        cats.add(new Cat("rijik"));
        cats.add(new Cat("murzik"));

//        map(Function<? super T, ? extends R> mapper)

        Function<Cat, String> function = new Function<Cat, String>() {
            @Override
            public String apply(Cat cat) {
                return cat.getName();
            }
        };
//        List<String> collect = cats.stream()
//                .map(Cat::getName)
//                .collect(Collectors.toList());

        List<String> collect = cats.stream()
                .map(Cat::getName)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(collect);

        collect.forEach(System.out::println);
    }

}

class Cat {

    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
