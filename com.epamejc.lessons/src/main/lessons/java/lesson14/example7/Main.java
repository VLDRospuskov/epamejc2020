package lessons.java.lesson14.example7;

import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        TreeSet<Integer> integers = new TreeSet<>();
        integers.add(3);
        integers.add(1);
        integers.add(100);
        integers.add(30);
        integers.add(63);
        System.out.println(integers);

        TreeSet<Cat> cats = new TreeSet<>();
        cats.add(new Cat(3));
        cats.add(new Cat(1));
        cats.add(new Cat(100));
        cats.add(new Cat(30));
        cats.add(new Cat(63));
        System.out.println(cats);
    }

}
