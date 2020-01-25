package homeworks.holidaysHW.recursion;

public class DigitsNumber {

    public static Integer numDig(Integer number) {
        if (number == 0) {
            return 0;
        }
        return 1 + numDig(number / 10);
    }

    public static void main(String[] args) {
        System.out.print(numDig(11111));
    }
}
