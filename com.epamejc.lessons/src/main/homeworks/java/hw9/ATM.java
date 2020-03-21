package homeworks.java.hw9;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ATM {

    private volatile double balance;
    private int index;
    private Bank bank;

    private final String withdrawTop = "\n================ WITHDRAW ================";
    private final String depositTop = "\n================ DEPOSIT =================";
    private final String checkBalanceTop = "\n================ CHECK BALANCE ===========";
    private final String bottom1 = "======== ATM #";
    private final String bottom2 = " balance: ";
    private final String bottom3 = " =========";

    public void withdraw(User user, ATM atm, double amount) {
        synchronized (bank) {
            if (amount < user.getBalance() && amount < atm.getBalance()) {
                balance -= amount;
                user.setBalance(user.getBalance() - amount);
                System.out.println(withdrawTop);
                System.out.println(user.getName() + " withdraw: " + String.format("%.2f", amount));
                System.out.println("User balance: " + String.format("%.2f", user.getBalance()));
                System.out.println(bottom1 + index + bottom2 + String.format("%.2f", balance) + bottom3);
            }
        }
    }

    public void deposit(User user, ATM atm, double amount) {
        synchronized (bank) {
            balance += amount;
            user.setBalance(user.getBalance() + amount);
            System.out.println(depositTop);
            System.out.println(user.getName() + " deposit: " + String.format("%.2f", amount));
            System.out.println("User balance: " + String.format("%.2f", user.getBalance()));
            System.out.println(bottom1 + index + bottom2 + String.format("%.2f", balance) + bottom3);
        }
    }

    public void checkUserBalance(User user, ATM atm) {
        synchronized (bank) {
            System.out.println(checkBalanceTop);
            System.out.println("User: " + user.getName() + "\nBalance: " + String.format("%.2f", user.getBalance()));
            System.out.println(bottom1 + index + bottom2 + String.format("%.2f", balance) + bottom3);
        }
    }

}
