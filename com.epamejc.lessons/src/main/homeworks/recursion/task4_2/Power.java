package main.homeworks.recursion.task4_2;

public class Power {

    public static int calcPow(int n, int p) {
        if (p == 0) {
            return 1;
        }
        return n * calcPow(n, p - 1);
    }
}
