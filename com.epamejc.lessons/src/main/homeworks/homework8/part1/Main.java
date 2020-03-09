package main.homeworks.homework8.part1;

public class Main {
    public static void main(String[] args) {

        Laptop<Integer> laptop = new Laptop<>("LG",
                "U4FDS7", 10,39000);
        int priseDiscount = laptop.priseWithDiscount(laptop::getPrise,
                laptop::getDiscountPercent,
                (prise, discount) -> (int)(prise.doubleValue() - ((discount.doubleValue()/100) * prise.doubleValue())));
        System.out.println(priseDiscount);

    }
}
