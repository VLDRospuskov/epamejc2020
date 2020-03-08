package lessons.lesson15.example6;

import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Integer integer = Stream.of(1, 2, 3, 4, 5)
                .skip(5)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("WRONG VALUE"));
        System.out.println(integer);
    }
}
