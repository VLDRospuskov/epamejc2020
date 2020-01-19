package main.homework.homework2.recursion;

public class DigitsCounter {
    
    private static int digitsCount = 1;

    public static int calculateDigitsNumber(int number) {

        countDigits(number);

        return digitsCount;
    }

    private static void countDigits(double number) {

        double result = 0.0;

        if (Math.abs(number) >= 10) {
            digitsCount++;
            result = number / 10;
            countDigits(result);
        }
    }

}