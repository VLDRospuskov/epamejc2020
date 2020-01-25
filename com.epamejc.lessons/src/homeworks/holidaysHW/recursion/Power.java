package homeworks.holidaysHW.recursion;

public class Power {

    public static Integer powNum(Integer number, Integer pow){
        if (pow > 0) {
            return number * powNum(number, pow - 1);
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.print(powNum(5,5));
    }
}
