package homeworks.homework2;

import java.util.Arrays;

public class Homework2 {
    
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 6};
        String string = "Igor";
        double aDouble = 3.14;
        
        ImmutableClass immutableClass = new ImmutableClass(ints, string, aDouble);
        
        int[] newInts = immutableClass.getAr();
        String newString = immutableClass.getName();
        double newDouble = immutableClass.getDoubleValue();
        
        System.out.println(Arrays.toString(newInts));
        System.out.println("String= " + newString);
        System.out.println("Double= " + newDouble);
    }
    
}
