package lessons.java.lesson21.example10;

import java.util.ArrayDeque;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        ArrayDeque<Integer> array = new ArrayDeque<>();
        array.offer(1);
        array.offer(2);
        array.offer(3);
        array.offer(4);
        array.offer(5);
        array.offer(6);
        System.out.println(array.stream().filter(n -> n != 5).collect(Collectors.toList()));
        System.out.println(array.getFirst());
        System.out.println(array.getLast());
    }
}
