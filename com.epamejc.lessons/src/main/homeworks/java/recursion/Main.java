package homeworks.java.recursion;

import static homeworks.java.recursion.RecursionFunctions.*;

public class Main {
    public static void main(String[] args) {

        for (int i = 0; i < 33; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println();

        System.out.println(pow(2, 3));
        System.out.println(pow(0.5, -2));

        System.out.println(numOfDigits(6));
        System.out.println(numOfDigits(1234567890));

    }
}
