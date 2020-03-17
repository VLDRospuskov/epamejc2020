package com.epamejc.lessons.src.homework.homework9.threads.bankSystem;

import java.math.BigDecimal;
import java.util.Random;

public class AtmOperations {
    private static final Random random = new Random();

    public static void withdrawRandom(Person person, ATM atm) {
        BigDecimal random = getRandomBigDecimal();
        System.out.println(person.getName() + " try to withdraw " + random
                + " from ATM " + atm.getId());
        BigDecimal temp = atm.withdraw(random);
        person.setBalance(person.getBalance().add(temp));
        System.out.println(person.getName() + " got: " + temp + ". Balance: " + person.getBalance().toString());
    }

    public static void depositRandom(Person person, ATM atm) {
        if (person.getBalance().compareTo(BigDecimal.TEN) > 0) {
            BigDecimal random = getRandomBigDecimal();
            while (random.compareTo(person.getBalance()) > 0) {
                random = getRandomBigDecimal();
            }
            atm.deposit(random);
            person.setBalance(person.getBalance().subtract(random));
            System.out.println(person.getName() + " deposit " + random
                    + " from ATM " + atm.getId());
        }
    }

    public static void encashment(ATM atm) {
        atm.encashment();
        System.out.println("Encashment of ATM:" + atm.getId() + " occurred.");
    }

    private static BigDecimal getRandomBigDecimal() {
        return BigDecimal.valueOf(Math.abs(random.nextDouble() + random.nextInt(40000)))
                .setScale(2, BigDecimal.ROUND_HALF_DOWN);
    }
}

