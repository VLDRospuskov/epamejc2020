package lessons.java.lesson22.example9;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Main {

    private static volatile int number = 0;
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    // why AtomicDouble
    public static void main(String[] args) {
        IntStream.iterate(1, n -> n + 1)
                .parallel()
                .limit(1_000_000)
                .forEach(n -> number++);

        System.out.println(number);

        IntStream.iterate(1, n -> n + 1)
                .parallel()
                .limit(1_000_000)
                .forEach(n -> atomicInteger.getAndIncrement());

        System.out.println(atomicInteger);
    }
}
