package Homeworks.HW9;

import Homeworks.HW9.Bank.ATM;
import Homeworks.HW9.Bank.Bank;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int moneySupply = 1_000_000;
        int atmsCount = 5;
        int usersCount = 10;
        Bank bank = new Bank(moneySupply, atmsCount, usersCount);
        //bank.makeOperations(1000);
    }
}
