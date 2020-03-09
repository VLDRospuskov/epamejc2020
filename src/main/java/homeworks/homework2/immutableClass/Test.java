package homeworks.homework2.immutableClass;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {

        ImmutableClass immutable = new ImmutableClass(0, "Oleg");

        System.out.println("Immutable:");
        System.out.println("id: " + immutable.getId());
        System.out.println("name: " + immutable.getName());
        System.out.println("map: " + immutable.getValueMap());

        OrdinaryClass ordinary = new OrdinaryClass();
        ordinary.setId(1);
        ordinary.setName("Gangsta");
        Map<Integer, String> valueMap = new HashMap<>();
        valueMap.put(ordinary.getId(), ordinary.getName());
        ordinary.setValueMap(valueMap);
        ordinary.setValueMap(2, "Angel");

        System.out.println("\nOrdinary: ");
        System.out.println("id: " + ordinary.getId());
        System.out.println("name: " + ordinary.getName());
        System.out.println("map: " + ordinary.getValueMap());
    }
}
