package homework.homework5.recursion;

public class DigitsCounter {

    public static int countDigits(int number) {
        return countDigits(number, 1);
    }

    private static int countDigits(double number, int digitsCount) {
        if (Math.abs(number) < 10) {
            return digitsCount;
        }
        return countDigits(number / 10, digitsCount + 1);
    }

}