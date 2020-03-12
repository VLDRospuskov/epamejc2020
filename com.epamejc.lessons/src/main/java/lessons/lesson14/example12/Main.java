package lessons.lesson14.example12;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        List<Integer> list3 = Arrays
                                      .asList(2, 4, 7, 10, 11, 45, 50, 59, 60, 66);
        System.out.println("(1) Index: "
                           + Collections.binarySearch(list3, 7));
        System.out.println("(2) Index: "
                           + Collections.binarySearch(list3, 9));
        List<String> list4 = Arrays.asList("blue", "green", "red");
        System.out.println("(3) Index: " + Collections.binarySearch(list4, "red"));
        System.out.println("(4) Index: " + Collections.binarySearch(list4, "cyan"));
        
    }
    
}
