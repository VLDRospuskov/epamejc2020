package homeworks.multiThreading;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class ThreadATMOperations extends Thread {

    public Bank bank;
    public User user;
    public ATM atm;

    @SneakyThrows
    public void run () {

        while (!bank.bankrupt && !user.bankrupt) {

            TimeUnit.SECONDS.sleep(1);

            bank.controlATM(atm, 1000, 50);
            if (bank.bankrupt) {
                break;
            }

            if(user.chooseRandomOperation()) {
                userDeposit();
            } else {
                userWithdraw();
            }
            System.out.println();
        }

    }

    private void userWithdraw() {

        double amount = user.getRandomAmount();

        boolean success = atm.withdraw(amount);
        user.setBalance(user.getBalance() + amount, success);
    }

    private void userDeposit() {

        double amount = user.getRandomAmount();

        if (user.getBalance() > 5) {
            atm.deposit(amount);
            user.setBalance(user.getBalance() - amount);
        } else {
            user.bankrupt = true;
            System.out.println("User: " + user.getName() + " bankrupt!");
        }
    }
}
