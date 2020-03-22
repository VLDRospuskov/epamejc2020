package main.homeworks.hw5;

public class Power {

    public static Integer powNum(Integer number, Integer pow){
        if (pow > 0) {
            return number * powNum(number, pow - 1);
        }
        return 1;
    }
}
