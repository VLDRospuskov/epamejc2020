package lessons.java.lesson7.example1;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        int[] mas = {3, 1, 10, 12, 2};
//        Integer[] mas2 = {3, 1, 10, 12, 2};
//        Arrays.sort(mas);
//        System.out.println(Arrays.toString(mas));
//
//        Arrays.sort(mas2);
//        System.out.println(Arrays.toString(mas2));

        Cat cat1 = new Cat("Barsik", 10);
        Cat cat2 = new Cat("Murzik", Integer.MIN_VALUE);
        Cat cat3 = new Cat("Rijik", 16);
        Cat[] cats = {cat1, cat2, cat3};
        Arrays.sort(cats);
        Arrays.sort(cats, new ReversedCat());
        System.out.println(Arrays.toString(cats));
    }

}
