package main.homeworks.hw5;

public class DigitsNumber {

    public static Integer numDig(Integer number) {
        int res = 1;
        if (number/10 == 0) {
            return 1;
        } else {
            res += numDig(number/10);
        }
        return res;
    }
}
