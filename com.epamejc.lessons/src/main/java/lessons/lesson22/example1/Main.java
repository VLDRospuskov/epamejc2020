package lessons.java.lesson22.example1;

import java.util.function.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Consumer<String> stringConsumer = (value -> System.out.print(value));
        stringConsumer.accept("fdsgh");

        Supplier supplier = () -> 10;
        System.out.println(supplier.get());

        Predicate<Integer> predicate = x -> x > 10;
        System.out.println(predicate.test(2));

        BiFunction<String, String, String> biFunction = (s1, s2) -> s1 + s2;
        System.out.println(biFunction.apply("hello", "world"));

        Function<Integer, String> function = s -> s + "erthj";
        System.out.println(function.apply(2));

        UnaryOperator<Integer> unaryOperator = s -> s + 10;
        System.out.println(unaryOperator.apply(23));
    }
}
