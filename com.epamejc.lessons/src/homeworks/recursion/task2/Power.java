package homeworks.recursion.task2;

public class Power {

    public int pow(int n, int p) {
        if (p == 0) {
            return 1;
        }

        if (p == 1) {
            return n;
        }

        return n * pow(n, p - 1);
    }
}
