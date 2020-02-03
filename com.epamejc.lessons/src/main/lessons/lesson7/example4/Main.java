package main.lessons.lesson7.example4;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int x = 1;
        List<Number> list = new ArrayList<Number>();
        list.add(1);
        list.add(345.2345);
        list.add(3);
        List<? extends Number> list1 = list;
        Number number = list1.get(0);
        Number number2 = list1.get(1);
        Number number3 = list1.get(2);
        System.out.println(number);
        System.out.println(number2);

    }

    private static List<? extends Number> getList(int x) {
        if (x == 1) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(2);
            list.add(3);
            return list;
        } else {
            List<Number> list = new ArrayList<>();
            list.add(1);
            list.add(2);
            list.add(3);
            return list;
        }
    }

}
