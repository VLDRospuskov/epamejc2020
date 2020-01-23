package main.homeworks.recursion.task4_3;

public class Digits {

    public int amountOfDigits(int n) {
        if (n / 10 == 0) {
            return 1;
        }
        return 1 + amountOfDigits(n / 10);
    }

}
