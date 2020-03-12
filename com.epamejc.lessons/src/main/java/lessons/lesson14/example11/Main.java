package lessons.lesson14.example11;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("yellow","red","green","blue");
        List<String> list2 = Arrays.asList("white","black");
        Collections.copy(list2, list1);
        System.out.println(list2);
//        List<GregorianCalendar> list3
//                = Collections.nCopies(5,
//                new GregorianCalendar(2005,0,1));
    }

}
