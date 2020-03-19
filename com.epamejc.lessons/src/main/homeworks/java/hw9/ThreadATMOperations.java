package homeworks.java.hw9;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Random;

@AllArgsConstructor
public class ThreadATMOperations extends Thread {

    private Bank bank;
    private List<ATM> atmList;
    private List<User> userList;

    @Override
    public void run() {
        while (true) {
            int chooseATM = generateRandomInt3();
            int chooseUser = generateRandomInt4();
            performAtmOperation(userList.get(chooseUser), atmList.get(chooseATM));
            performAtmService(atmList.get(chooseATM));
        }
    }

    private void performAtmOperation(User user, ATM atm) {
        int chooseOperation = generateRandomInt3();
        if (chooseOperation == 0) {
            atmWithdraw(user, atm);
        } else if (chooseOperation == 1) {
            atmDeposit(user, atm);
        } else {
            atmCheckUserBalance(user, atm);
        }
    }

    private void atmWithdraw(User user, ATM atm) {
        double amount = generateRandomAmount();
        atm.withdraw(user, atm, amount);
    }

    private void atmDeposit(User user, ATM atm) {
        double amount = generateRandomAmount();
        atm.deposit(user, atm, amount);
    }

    private void atmCheckUserBalance(User user, ATM atm) {
        atm.checkUserBalance(user, atm);
    }

    private void performAtmService(ATM atm) {
        double amount = 500.00;
        double maxBalance = 2500.00;
        double minBalance = 750.00;
        if (atm.getBalance() > maxBalance) {
            bank.collectMoneyFromAtm(atm, amount);
        } else if (atm.getBalance() < minBalance) {
            bank.fillAtmWithMoney(atm, amount);
        }
    }

    private int generateRandomInt3() {
        return new Random().nextInt(3);
    }

    private int generateRandomInt4() {
        return new Random().nextInt(4);
    }

    private Double generateRandomAmount() {
        return new Random().nextDouble() + new Random().nextInt(500);
    }

}
