package homeworks.java.hw5.recursion.countnumbers;

import static homeworks.java.hw5.recursion.countnumbers.Counter.counterOfNumbers;

public class Main {

    public static void main(String[] args) {

        try {
            System.out.println(counterOfNumbers(164651351615L));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

    }

}
