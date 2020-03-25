package experiments.example4;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

public class _C {

    public static void main(String[] args) {
        System.out.println(test(i -> i == 5));
        System.out.println(test((i) -> i == 5));
        System.out.println(test((i) -> {return i == 5;}));
        System.out.println(1 % 2);

        String s = "hello";


        int[] arr = new int[1];
        int[] arr2 = new int[1];

        System.out.println(Arrays.equals(arr, arr2));

        ArrayList<String> strings = new ArrayList<>();

        LocalDateTime d = LocalDateTime.of(2015, 5, 10, 11, 22, 33);
        Period p = Period.ofDays(1).ofYears(2);
        d = d.minus(p);
        DateTimeFormatter f = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        System.out.println(f.format(d));

    }

    private static boolean test(Predicate<Integer> p) {
        System.out.println();
        return p.test(5);

    }

}
