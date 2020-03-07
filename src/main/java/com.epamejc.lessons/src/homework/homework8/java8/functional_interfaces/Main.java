package com.epamejc.lessons.src.homework.homework8.java8.functional_interfaces;

public class Main {
    public static void main(String[] args) {
        BankAccount ba = new BankAccount("Goose");
        CoolBiFunction<String, String, Long> biFunc = (s1, s2) -> (long) (31 * s1.hashCode() + s2.hashCode());
        CoolSupplier<String> supp = () -> "Duck";
        ba.fillFields(biFunc, supp);
        System.out.println(ba);
    }
}
