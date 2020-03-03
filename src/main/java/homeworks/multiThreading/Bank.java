package homeworks.multiThreading;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Bank {

    public String name;
    private double balance;
    public volatile boolean bankrupt;

    public void controlATM (ATM atm, double max, double min) {

        System.out.println("Bank balance: " + balance);
        double atmBalance = atm.getBalance();

        if (atmBalance > max) {

            depositATM(atm, atmBalance, max);

        } else if (atmBalance <= min) {

            withdrawATM(atm, atmBalance, max);

        }
    }

    private void withdrawATM(ATM atm, double atmBalance, double max) {
        synchronized (ThreadController.lock) {
            if (balance > max / 2) {

                atm.setBalance(max / 2);
                balance -= max / 2 - atmBalance;
                System.out.println("ATM " + atm.getName() + " got money from bank!\n");

            } else {
                System.out.println("Oops we are bankrupt!");
                bankrupt = true;
            }
        }
    }

    private void depositATM (ATM atm, double atmBalance, double max) {
        synchronized (ThreadController.lock) {
            atm.setBalance(max / 2);
            balance += atmBalance - max / 2;
            System.out.println("ATM gave " + atm.getName() + " money to bank!\n");
        }
    }
}
