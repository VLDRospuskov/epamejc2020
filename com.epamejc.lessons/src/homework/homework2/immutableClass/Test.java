package homework.homework2.immutableClass;

import java.util.HashMap;

class Test {
    public static void main(String[] args) {

        ImmutableClass immute = new ImmutableClass(0, "Oleg");
        System.out.println("Immutabe:");
        System.out.println("id: " + immute.getId());
        System.out.println("name: " + immute.getName());
        System.out.println("map: " + immute.getValueMap());

        OrdinaryClass ordy = new OrdinaryClass();
        ordy.setId(1);
        ordy.setName("Gangsta");
        HashMap valueMap = new HashMap();
        valueMap.put(ordy.getName(), ordy.getId());
        ordy.setValueMap(valueMap);
        ordy.setValueMap(2, "Angel");
        System.out.println("\nOrdinary: ");
        System.out.println("id: " + ordy.getId());
        System.out.println("name: " + ordy.getName());
        System.out.println("map: " + ordy.getValueMap());
    }
}
