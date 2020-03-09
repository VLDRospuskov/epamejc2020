package homeworks.HW_8_Java8.functionalInterfaces;

public class Calculator {

    public static int getRandomInt(MySupplier<Integer> mySupplier) {
        return mySupplier.get();
    }

}
