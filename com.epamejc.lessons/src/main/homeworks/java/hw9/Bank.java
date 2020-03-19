package homeworks.java.hw9;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Bank {

    private volatile double balance;

    private final String collectingTop = "\n================ ATM COLLECTING ===========";
    private final String fillTop = "\n================ ATM FILLING =============";
    private final String bottom1 = "======== ATM #";
    private final String bottom2 = " balance: ";
    private final String bottom3 = " =========";

    public synchronized void collectMoneyFromAtm(ATM atm, double amount) {
        balance += amount;
        atm.setBalance(atm.getBalance() - amount);
        System.out.println(collectingTop);
        System.out.println("ATM # " + atm.getIndex() + " collect out: " + String.format("%.2f", amount));
        System.out.println("Bank balance: " + String.format("%.2f", balance));
        System.out.println(bottom1 + atm.getIndex() + bottom2 + String.format("%.2f", atm.getBalance()) + bottom3);
    }

    public synchronized void fillAtmWithMoney(ATM atm, double amount) {
        if (amount < balance) {
            balance -= amount;
            atm.setBalance(atm.getBalance() + amount);
            System.out.println(fillTop);
            System.out.println("ATM #" + atm.getIndex() + " fill in: " + String.format("%.2f", amount));
            System.out.println("Bank balance: " + String.format("%.2f", balance));
            System.out.println(bottom1 + atm.getIndex() + bottom2 + String.format("%.2f", atm.getBalance()) + bottom3);
        } else {
            System.out.println("\nBank OUT OF MONEY\n");
        }
    }

}
