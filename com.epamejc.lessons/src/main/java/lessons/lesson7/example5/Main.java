package lessons.lesson7.example5;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<? super Number> list1 = new ArrayList<>();

        List<? super Number> list2 = new ArrayList<Number>();
        List<? super Number> list3 = new ArrayList<Object>();
        List<? super Object> list4 = new ArrayList<Object>();
//        List<? super Number> list4 = new ArrayList<Integer>();

        list1.add(null);
        list1.add(Integer.valueOf(1));
        list1.add(new Integer(1234));
        list1.add(new Double(1234.345));
//        list1.add(new Object());
        Number number = 10;
        list1.add(number);

        Object object = list1.get(0);
        Integer number1 = (Integer) list1.get(0);

        list4.add("DFsghj");
        list4.add(534);
        System.out.println(list4.get(0));
        System.out.println(list4.get(1));
    }

}
