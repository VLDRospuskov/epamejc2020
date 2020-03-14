package homeworks.hw9;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ATM {

    private String nameATM;

    public synchronized void deposit(Double amount, User user) {
        if (user.getUserBalance() >= amount) {
            CommonBalance.balance += amount;
            user.setUserBalance(user.getUserBalance() - amount);
            System.out.println("Money (" + amount + ") was deposit by " + user.getName() + " via ATM: " + nameATM);
            System.out.println("User balance: " + user.getUserBalance() +
                                ". Common ATM balance: " + CommonBalance.balance);
        } else {
            throw new RuntimeException(String.format("User does not have enough money. " +
                                                        "Current balance: " + user.getUserBalance()));
        }
    }

    public synchronized void withdraw(Double amount, User user) {
        if (CommonBalance.balance >= amount) {
            CommonBalance.balance -= amount;
            user.setUserBalance(user.getUserBalance() + amount);
            System.out.println("Money (" + amount + ") was withdrawn by " + user.getName() + " via ATM: " + nameATM);
            System.out.println("User balance: " + user.getUserBalance() +
                                ". Common ATM balance: " + CommonBalance.balance);
        } else {
            throw new RuntimeException(String.format("Not enough money in the ATMs' common balance." +
                                            " Current ATMs' common balance:" + CommonBalance.balance));
        }
    }

}
