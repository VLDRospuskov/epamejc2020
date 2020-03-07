package com.epamejc.lessons.src.homework.homework9.threads.bankSystem;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
public class Person {
    private String name;
    private BigDecimal balance;
}
