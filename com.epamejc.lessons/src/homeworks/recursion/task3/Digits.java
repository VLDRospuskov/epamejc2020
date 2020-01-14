package homeworks.recursion.task3;

public class Digits {

    public int numDigits(int n) {
        if (n > - 10 && n < 10) {
            return 1;
        }
        return 1 + numDigits(n / 10);
    }
}
