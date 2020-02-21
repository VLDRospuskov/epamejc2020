package lessons.java.lesson16.example5;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new Object());
        list.add(1);
        list.add(2.0);

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));

        ////////////////////////
        List<?> list2 = null;
//        list2.add("dfasgh");
//        list2.add(1);
//        list2.add(null);
//        list2.add(new Object());
    }

}
