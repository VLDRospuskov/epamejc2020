package com.epamejc.lessons.src.homework.homework8.java8.functional_interfaces;

import lombok.Data;


@Data
public class BankAccount {
    private Long id;
    private String organizationName;
    private String owner;

    public BankAccount(String organizationName) {
        this.organizationName = organizationName;
    }

    public void fillFields(CoolBiFunction<String, String, Long> idBiFunction, CoolSupplier<String> ownerSupplier) {
        owner = ownerSupplier.get();
        id = idBiFunction.apply(organizationName, owner);
    }
}
