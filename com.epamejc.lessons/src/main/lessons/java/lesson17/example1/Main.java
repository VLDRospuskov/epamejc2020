package lessons.java.lesson17.example1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        final int moreThanThree = getMoreThanThree();
        List<Integer> collect = integers.stream()
                .filter(number -> number > moreThanThree)
                .filter(number -> number > moreThanThree)
                .collect(Collectors.toList());
    }

    private static int getMoreThanThree() {
        boolean isDone = false;
        if (isDone) {
            return 3;
        } else {
            return 4;
        }
    }

}
