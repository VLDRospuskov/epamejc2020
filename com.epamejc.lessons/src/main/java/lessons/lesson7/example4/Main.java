package lessons.lesson7.example4;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int x = 1;
        List<Number> list = new ArrayList<Number>();
        list.add(1);
        list.add(345.2345);
        list.add(3);
        List<? extends Number> list1 = new ArrayList<>();


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
