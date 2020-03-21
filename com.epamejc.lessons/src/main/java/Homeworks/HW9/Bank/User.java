package Homeworks.HW9.Bank;

import lombok.SneakyThrows;
import lombok.ToString;

@ToString
public class User {

    private final Object userLock = new Object();
    private final int userOperationTime = 500;

    int id;
    int balance;

    @SneakyThrows
    public User(int id, int balance) {
        Thread.sleep(userOperationTime);
        this.id = id;
        this.balance = balance;
        System.out.println("Created new User with id: " + id + " and balance " + balance);
    }

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


class UserException extends RuntimeException {

    public UserException(String message) {
        super(message);
    }
}
