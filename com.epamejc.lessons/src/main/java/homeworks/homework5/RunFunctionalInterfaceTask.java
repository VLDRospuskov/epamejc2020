package homeworks.homework5;

public class RunFunctionalInterfaceTask {

    public static void main(String[] args) {
        MyBiFunction<? super Number, ? super Number, Boolean> myBiFunction = (f, s) -> (int)f %(int)s == 0;
        System.out.println(myBiFunction.apply(16, 4));

        MySupplier<Integer> mySupplier = () -> (int)(Math.random()*100);
        System.out.println(mySupplier.get());
        System.out.println(useInterfaceAsArgument(() -> (int)(Math.random()*100), () -> (int)(Math.random()*100),
                (f,s) -> {
            System.out.println("First value =  " + f);
            System.out.println("Second value = " + s);
            return (int)f % (int)s == 0;
                }));
    }

    private static Boolean useInterfaceAsArgument(MySupplier<? extends Number> mySupplier1,
                                                  MySupplier<? extends Number> mySupplier2,
                                                  MyBiFunction<? super Number, ? super Number, ? extends Boolean> myBiFunction){

        return myBiFunction.apply(mySupplier1.get(),mySupplier2.get());
    }

}
