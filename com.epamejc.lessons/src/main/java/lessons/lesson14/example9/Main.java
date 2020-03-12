package lessons.lesson14.example9;

import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    
    public static void main(String[] args) {
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>(
                16, 0.75f, true);
        linkedHashMap.put("Smith", 30);
        linkedHashMap.put("Anderson", 31);
        linkedHashMap.put("Lewis", 29);
        linkedHashMap.put("Cook", 29);
        System.out.println("\nThe age for " + "Lewis is " + linkedHashMap.get("Smith")
                                                                         .intValue());
        System.out.println(linkedHashMap);
    }
    
}
