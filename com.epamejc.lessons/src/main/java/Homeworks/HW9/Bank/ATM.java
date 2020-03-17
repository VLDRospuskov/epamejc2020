package Homeworks.HW9.Bank;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ATM {

    int id;
    int balance;

    public int deposit(int amount) {
        this.balance += amount;
        return amount;
    }

    public int withdraw(int amount) throws ATMException {
        if (this.balance >= amount) {
            this.balance -= amount;
            return amount;
        } else {
            throw new ATMException("ATM " + this.id + " don't have enough amount on balance!");
        }
    }

}

class ATMException extends Exception {

    public ATMException(String message) {
        super(message);
    }
}