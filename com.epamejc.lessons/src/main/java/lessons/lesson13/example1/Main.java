package lessons.lesson13.example1;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        ArrayList<Object> arrayList = new ArrayList<>();
//        Vector<Object> objects = new Vector<>();
        Collections.synchronizedList(arrayList);

    }
}
