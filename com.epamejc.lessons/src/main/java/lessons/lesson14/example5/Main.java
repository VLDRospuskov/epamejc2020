package lessons.lesson14.example5;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// пересчет
public class Main {
    
    public static void main(String[] args) {
        HashMap<Cat, String> catMap = new HashMap<>();
        
        Cat cat = new Cat(100, 2);
        Cat cat2 = new Cat(2, 100);
        
        System.out.println(cat.hashCode());
        System.out.println(cat2.hashCode());
        // 6200 - 6192 = 8 (0 1 2 3 4 5 6 (7))
        catMap.put(cat, "rijik");
        catMap.put(cat2, null);
        
        catMap.get(cat);
        catMap.get(cat2);
        System.out.println(catMap);
        
        Set<Map.Entry<Cat, String>> entries = catMap.entrySet();
        Iterator<Map.Entry<Cat, String>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Cat, String> next = iterator.next();
            next.getKey();
        }
    }
    
}
