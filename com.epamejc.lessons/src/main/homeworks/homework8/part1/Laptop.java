package main.homeworks.homework8.part1;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Laptop<T> {

    private String manufacturer;
    private String model;
    private T discountPercent;
    private T prise;

    <U> U priseWithDiscount(MySupplier<? extends Number> supplierPrise,
                            MySupplier<? extends Number> supplierDiscount,
                            MyBiFunction <? super Number, ? super Number, ? extends U> biFunction) {
        Number prise = supplierPrise.get();
        Number discount = supplierDiscount.get();
        return biFunction.apply(prise, discount);
    }

}
