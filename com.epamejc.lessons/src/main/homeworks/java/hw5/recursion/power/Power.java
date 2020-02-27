package homeworks.java.hw5.recursion.power;

public class Power {

    public static long raiseBaseXToPositiveIntegerPowerN(int x, int n) {
        if (x < 0 || n < 0) {
            throw new ArithmeticException("Invalid input");
        }

        long result = 1;
        if (x == 1 || n == 0) {
            return result;
        }
        result = x * raiseBaseXToPositiveIntegerPowerN(x, n - 1);
        return result;
    }

}
