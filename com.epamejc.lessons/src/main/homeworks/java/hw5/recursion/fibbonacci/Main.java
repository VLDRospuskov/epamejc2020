package homeworks.java.hw5.recursion.fibbonacci;

import static homeworks.java.hw5.recursion.fibbonacci.Fibbonachi.findInFibbonachiRow;

public class Main {

    public static void main(String[] args) {

        try {
            System.out.println(findInFibbonachiRow(16));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

    }

}
