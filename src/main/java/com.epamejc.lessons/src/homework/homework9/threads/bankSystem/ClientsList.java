package com.epamejc.lessons.src.homework.homework9.threads.bankSystem;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class ClientsList {
    public static List<Person> getClients() {
        return Arrays.asList(
                new Person("Maria", BigDecimal.valueOf(10_000)),
                new Person("Ann", BigDecimal.valueOf(95_000)),
                new Person("Denis", BigDecimal.valueOf(1000)),
                new Person("Alexandra", BigDecimal.valueOf(50_000)),
                new Person("Peter", BigDecimal.valueOf(20_000))
        );
    }
}
