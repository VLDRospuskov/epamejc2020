package lessons.java.lesson15.example1;

import java.util.function.*;

public class Main {

    public static void main(String[] args) {
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String string) {
                System.out.println(string);
            }
        };
        Consumer<String> consumer2 = str -> System.out.println(str);
        consumer2.accept("hello world");

        System.out.println("=============================");

        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer > 5;
            }
        };
        Predicate<Integer> predicate2 = integer -> integer > 5;
        System.out.println(predicate.test(10));

        System.out.println("=============================");

        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return "hello";
            }
        };
        Supplier<String> supplier2 = () -> {
            System.out.println("string supplier 2");
            return "hello";
        };
        System.out.println(supplier2.get());

        System.out.println("=============================");
        Function<Integer, String> function = new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return integer > 10 ? "yes" : "no";
            }
        };
        Function<Integer, String> function2 = (integer) -> integer > 10 ? "yes" : "no";
        System.out.println(function2.apply(23));

        System.out.println("=============================");

        BiFunction<String, Integer, String> biFunction =
                new BiFunction<String, Integer, String>() {
                    @Override
                    public String apply(String s, Integer integer) {
                        return s + integer;
                    }
                };
        BiFunction<String, Integer, String> biFunction2 = (str, integer) -> str + integer;
        System.out.println(biFunction2.apply("biFunction string ", 100));
    }

}
