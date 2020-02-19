package lessons.lesson7.example8;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Day friday = Day.FRIDAY;
        Day monday = Day.MONDAY;
        Day saturday = Day.SATURDAY;
        List<Day> days =  new ArrayList<>();
        days.add(friday);
        days.add(monday);
        days.add(saturday);
        Collections.sort(days);
//        [MONDAY, FRIDAY, SATURDAY]
        System.out.println(days);
        Day[] values = Day.values();
        System.out.println(Arrays.toString(values));
        int i = Day.SATURDAY.compareTo(Day.SUNDAY);
        System.out.println(i);
        System.out.println( Day.MONDAY + " isWeekEnd(): " + Day.MONDAY.isWeekend() );

    }

    private static Day getDay() {
        return Day.MONDAY;
    }
}
