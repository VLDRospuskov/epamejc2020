package homeworks.hw5;

public class DigitsNumber {

    public static Integer numDig(Integer number) {
        if (number == 0) {
            return 0;
        }
        return 1 + numDig(number / 10);
    }
}
