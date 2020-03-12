package lessons.lesson14.example3;

import java.util.ArrayDeque;

public class Main {

    public static void main(String[] args) {
        ArrayDeque<Integer> integers = new ArrayDeque<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        integers.add(6);
//        integers.addFirst();
        System.out.println(integers.getFirst());
        System.out.println(integers.getLast());
    }
}
