package homeworks.HW8_functionalAndStream.myFunctional;

public class Statistics<T> {

    private T polesNumber;
    private T winsNumber;
    private boolean isTitleWon;

    public Statistics(T polesNumber, T winsNumber, boolean isTitleWon) {
        this.polesNumber = polesNumber;
        this.winsNumber = winsNumber;
        this.isTitleWon = isTitleWon;
    }

    public T getPolesNumber() {
        return polesNumber;
    }

    public T getWinsNumber() {
        return winsNumber;
    }

    public boolean isTitleWon() {
        return isTitleWon;
    }

    public <R> R calculateBonuses(MySupplier<? extends Number> mySupplier1,
                                  MySupplier<? extends Number> mySupplier2,
                                  MyBiFunction<? super Number, ? super Number, ? extends R> myBiFunction) {

        Number number1 = mySupplier1.get();
        Number number2 = mySupplier2.get();
        return myBiFunction.apply(number1, number2);
    }

    public <R> R calculateTitleBonus(MySupplier<? extends Boolean> mySupplier1,
                                      MySupplier<? extends Number> mySupplier2,
                                      MyBiFunction<? super Boolean, ? super Number, ? extends R> myBiFunction) {

        Boolean boolean1 = mySupplier1.get();
        Number number2 = mySupplier2.get();
        return myBiFunction.apply(boolean1, number2);
    }
}
