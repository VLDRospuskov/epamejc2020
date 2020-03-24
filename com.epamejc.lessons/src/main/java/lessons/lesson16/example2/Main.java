package lessons.lesson16.example2;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public void Producer() {
        List<? extends Number> list = getList();
        Number number = 10;
//        list.add(number);
//        list.add(1);
//        list.add(2.0);

        Number number1 = list.get(0);
    }

    public List getList() {
        boolean isDone = false;
        if (isDone) {
            ArrayList<Integer> integers = new ArrayList<>();
            integers.add(1);
            integers.add(2);
            integers.add(3);
            return integers;
        } else {
            return new ArrayList<Double>();
        }
    }

    public void Consumer() {
        List<? super Number> list = new ArrayList<>();
        Number number = 10;
        list.add(number);
        list.add(1);
        list.add(2.0);
        list.add(null);
//        list.add("sdfgh");
//        list.add(new Object());

        Object object = list.get(0);
    }

}
