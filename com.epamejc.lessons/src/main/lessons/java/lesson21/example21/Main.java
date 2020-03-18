package lessons.java.lesson21.example21;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        IntStream.iterate(10, i -> i + 1)
                .parallel()
                .limit(100)
                .map(i -> {
                    arrayList.add(i);
                    return i;
                })
                .forEachOrdered(System.out::println);
        System.out.println("--------------------------");
        arrayList.forEach(System.out::println);
    }

}
