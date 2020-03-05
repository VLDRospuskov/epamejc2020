package homework8.task1;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
class Bicycle<T> {

    int numberOfSpeeds;
    double price;

    <R> R buyBike(MySupplier<? extends Number> supplierSpeed,
                  MySupplier<? extends Number> supplierPrice,
                  MyBiFunction<? super Number, ? super Number, ? extends R> myBiFunction) {

        Number numberOfSpeeds = supplierSpeed.get();
        Number price = supplierPrice.get();
        return myBiFunction.apply(numberOfSpeeds, price);
    }
}
