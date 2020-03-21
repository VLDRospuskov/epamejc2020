package Homeworks.HW8.part1;

public class BiFunction {
    public static void main(String[] args) {
        java.util.function.BiFunction<Integer, Integer, Boolean> biFunction = (x, y) -> x > y;
        System.out.println(biFunction.apply(2, 3));
        System.out.println(biFunction.apply(3, 3));
        System.out.println(biFunction.apply(4, 3));
    }
}
