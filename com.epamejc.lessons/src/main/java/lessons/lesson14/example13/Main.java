package lessons.lesson14.example13;

import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Collection<String> collection
                = Arrays.asList("red", "green", "blue");
        System.out.println(Collections.max(collection));
        System.out.println(Collections.min(collection));
        Set<String> one = Collections.singleton("One");
        new ArrayList<>().removeAll(one);
        
    }
    
}
