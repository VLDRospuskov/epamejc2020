package homeworks.java.hw9;

import java.util.Random;

public class ThreadATMOperations extends Thread {

    private final Bank bank;
    private final ATM atm;
    private final User user;

    public ThreadATMOperations(Bank bank, ATM atm, User user) {
        super(user.getName());
        this.bank = bank;
        this.atm = atm;
        this.user = user;
    }

    @Override
    public void run() {
        while (true) {
            atmOperate();
            bankOperate();
        }
    }

    private void atmOperate() {
            final int chooseOperation = generateRandomInt();
            if (chooseOperation == 1) {
                atmWithdraw();
            } else if (chooseOperation == 2) {
                atmDeposit();
            } else {
                atmCheckUserBalance();
            }
    }

    private synchronized void atmWithdraw() {
            double amount = generateRandomAmount();
            if (amount < user.getBalance() && amount < atm.getBalance()) {
                atm.withdraw(amount);
                user.setBalance(user.getBalance() - amount);
                System.out.println("\n================ WITHDRAW ==================");
                System.out.println("User name: " + user.getName() + " withdraw: " + String.format("%.2f", amount));
                System.out.println("ATM " + atm.getIndex() + " balance: " + String.format("%.2f", atm.getBalance()));
                System.out.println("=========================================\n");
            }
    }

    private synchronized void atmDeposit() {
            double amount = generateRandomAmount();
            atm.deposit(generateRandomAmount());
            user.setBalance(user.getBalance() + amount);
            System.out.println("\n================ DEPOSIT ==================");
            System.out.println("User name: " + user.getName() + " deposit: " + String.format("%.2f", amount));
            System.out.println("ATM " + atm.getIndex() + " balance: " + String.format("%.2f", atm.getBalance()));
            System.out.println("=========================================\n");
    }

    private synchronized void atmCheckUserBalance() {
            System.out.println("\n================ CHECK BALANCE ============");
            System.out.println("User name: " + user.getName() + " balance: " + String.format("%.2f", user.getBalance()));
            System.out.println("============================================\n");
    }



    private void bankOperate() {
            double amount = 500.00;
            if (atm.getBalance() > 2500.00) {
                    bankCollectAtm(amount);
            } else if (atm.getBalance() < 750.00) {
                    bankFillAtm(amount);
            }
    }

    private synchronized void bankCollectAtm(double amount) {
            bank.collect(amount);
            atm.setBalance(atm.getBalance() - amount);
            System.out.println("\n================ COLLECTING ==================");
            System.out.println("ATM # " + atm.getIndex() + " collect out: " + String.format("%.2f", amount));
            System.out.println("Bank balance: " + String.format("%.2f", bank.getBalance()));
            System.out.println("===============================================\n");
    }

    private synchronized void bankFillAtm(double amount) {
            if (amount < bank.getBalance()) {
                bank.fill(amount);
                atm.setBalance(atm.getBalance() + amount);
                System.out.println("\n================ FILLING =====================");
                System.out.println("ATM #" + atm.getIndex() + " fill in: " + String.format("%.2f", amount));
                System.out.println("Bank balance: " + String.format("%.2f", bank.getBalance()));
                System.out.println("===============================================\n");
            } else {
                System.out.println("\nBank OUT OF MONEY\n");
            }
    }

    private int generateRandomInt() {
        return new Random().nextInt(4);
    }

    private Double generateRandomAmount() {
        return new Random().nextDouble() + new Random().nextInt(500);
    }
}
