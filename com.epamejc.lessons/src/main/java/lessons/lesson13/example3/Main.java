package lessons.lesson13.example3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1); // new Integer(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

//        Iterator<Integer> listIterator = list.iterator();

//        for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext(); ) {
//            Integer currentNumber = iterator.next();
//            if (currentNumber > 3) {
////                list.remove(currentNumber);
//                iterator.remove();
//            }
//        }
        
        Predicate<Integer> predicate = integer -> list.remove(integer);
        System.out.println(predicate.test(4));
        System.out.println(list);
        
    }
    
}
