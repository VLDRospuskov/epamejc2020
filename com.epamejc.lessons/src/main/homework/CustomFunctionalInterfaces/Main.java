package homework.CustomFunctionalInterfaces;

public class Main {

    public static void main(String[] args) {
        CustomBiFunction<Boolean, Integer, Integer> customBiFunction = (a, b) -> a > b;
        boolean res = customBiFunction.apply(4, 5);
        System.out.println(res);

        CustomSupplier<Boolean> customSupplier = () -> 5 > 4;
        boolean res1 = customSupplier.get();
        System.out.println(res1);

        System.out.println(applyFunctionalInterfaces((a, b) -> {
            System.out.println(a.getClass() + "\t" + a.toString());
            System.out.println(b.getClass() + "\t" + b.toString());

            return a.doubleValue() >= b.doubleValue();
        }, () -> 7, () -> 7.45));
    }

    private static Boolean applyFunctionalInterfaces(
            CustomBiFunction<? extends Boolean, ? super Number, ? super Number> customBiFunction,
            CustomSupplier<? extends Number> customSupplier1,
            CustomSupplier<? extends Number> customSupplier2) {
        return customBiFunction.apply(customSupplier1.get(), customSupplier2.get());
    }
}
