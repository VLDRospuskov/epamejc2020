package Homeworks.HW9.Bank;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class User {

    int id;
    int balance;

    public int deposit(int amount) throws UserException {
        if (balance >= amount) {
            this.balance -= amount;
            return amount;
        } else {
            throw new UserException("User " + this.id + " don't have sufficient funds!");
        }
    }

    public int withdraw(int amount) {
        this.balance += amount;
        return amount;
    }
}

class UserException extends Exception {

    public UserException(String message) {
        super(message);
    }
}
