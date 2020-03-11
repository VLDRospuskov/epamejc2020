package homeworks.homework9_multithreading.model;


import homeworks.homework9_multithreading.exception.AccountNotFoundException;
import homeworks.homework9_multithreading.myenum.Operation;

import java.math.BigDecimal;

public class ATM {
    private String adress;
    private volatile BigDecimal balance;
    private final Bank bank;
    private final Object mutex;

    public ATM(String adress, BigDecimal balance, Bank bank) {
        this.adress = adress;
        this.balance = balance;
        this.bank = bank;
        mutex = new Object();
    }

    public void makeOperation(BigDecimal amount, Person person, Operation operation) {
        synchronized (mutex) {
            if (operation.equals(Operation.DEPOSIT)) {
                deposit(amount, person);
            } else {
                withdraw(amount, person);
            }
        }
    }

    public void deposit(BigDecimal amount, Person person) {
        synchronized (mutex) {
            try {
                bank.updateAccountBalance(person.getCard(), amount);
                balance = balance.add(amount);
                System.out.printf("%s made deposit %s on %s atm balance is %f \n", person, amount, adress, balance);
            } catch (AccountNotFoundException ex) {
                System.out.println(ex.getMessage() + "is not valid for deposit operation");
            }
        }


    }

    public void withdraw(BigDecimal amount, Person person) {
        synchronized (mutex) {
            try {
                BigDecimal limit = bank.getAccountBalance(person.getCard());
                if (limit.compareTo(amount) >= 0) {
                    withdraw(limit, amount, person);
                } else {
                    System.out.printf("%s don`t have enough money \n", person);
                    balance = bank.getMoney(new BigDecimal(2000));
                    System.out.printf("Bank balance: %s\n", bank.getBalance());
                }

            } catch (AccountNotFoundException ex) {
                System.out.println(ex.getMessage() + "is not valid for withdraw operation");
            }
        }
    }

    private void withdraw(BigDecimal limit, BigDecimal amount, Person person) {
        synchronized (mutex) {
            if (balance.compareTo(limit) >= 0) {
                balance = balance.subtract(amount);
                System.out.printf("%s made withdraw %s on %s atm balance is %f \n", person, amount, adress, balance);
            } else {
                System.out.println("ATM dont have enough money");
            }
        }
    }

}
