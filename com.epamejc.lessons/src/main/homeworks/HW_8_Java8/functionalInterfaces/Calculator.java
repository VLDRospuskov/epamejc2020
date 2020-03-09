package homeworks.HW_8_Java8.functionalInterfaces;

public class Calculator {

    public static int getRandomInt(MySupplier<Integer> mySupplier) {
        return mySupplier.get();
    }

    public static Double getSumAsDouble(int n1, int n2, MyBiFunction<Integer, Integer, Double> myBiFunction) {
        return myBiFunction.apply(n1, n2);
    }

}
