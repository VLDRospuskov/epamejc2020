package Homeworks.HW8.part1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("Barsik", 5));
        cats.add(new Cat("Murzik", 7));
        cats.add(new Cat("Milka", 1));

        System.out.println(cats);

        Supplier<Cat> supplier = () -> new Cat("Rijik", 4);
        cats.add(supplier.get());

        System.out.println(cats);
    }

}
