package homeworks.HW9_multithreading;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ATM {

    private BankAccount bankAccount;
    private int ATMindex;

    public ATM(BankAccount bankAccount, int index) {
        this.bankAccount = bankAccount;
        this.ATMindex = index;
    }

    /**
     * Method for depositing money into a bank account
     *
     * @param amount deposit amount
     * @param user   user who deposits money from the account
     * @throws InterruptedException exception, if there're troubles with thread
     */
    public void deposit(BigDecimal amount, User user) throws InterruptedException {
        synchronized (bankAccount.getBankLock()) {
            synchronized (user.getUserLock()) {
                if (user.isEnoughUserBalance(amount)) {
                    bankAccount.increaseBankBalance(amount);
                    user.decreaseUserBalance(amount);
                    System.out.println(user.getName() + " deposit: " + amount);
                } else {
                    System.out.println("\u001B[31m" + user.getName()
                            + " can not deposit " + amount.longValue() + "\u001B[0m");
                }
                System.out.println(user.getName() + " balance: " + user.getUserBalance().longValue());
            }
            System.out.println("Bank balance: " + bankAccount.getBankBalance() + "\n");
            Thread.sleep(1000);
        }
    }

    /**
     * Method for withdrawing money from a bank account
     *
     * @param amount withdraw amount
     * @param user   user who withdraws money from the account
     * @throws InterruptedException exception, if there're troubles with thread
     */
    public void withdraw(BigDecimal amount, User user) throws InterruptedException {
        synchronized (bankAccount.getBankLock()) {
            synchronized (user.getUserLock()) {
                if (bankAccount.isEnoughBankBalance(amount)) {
                    bankAccount.decreaseBankBalance(amount);
                    user.increaseUserBalance(amount);
                    System.out.println(user.getName() + " withdraw: " + amount);
                } else {
                    System.out.println("\u001B[31m" + user.getName()
                            + " can not withdraw " + amount.longValue() + "\u001B[0m");
                }
                System.out.println(user.getName() + " balance: " + user.getUserBalance().longValue());
            }
            System.out.println("Bank balance: " + bankAccount.getBankBalance() + "\n");
            Thread.sleep(1000);
        }
    }

    /**
     * Method checks {@paramref user} balance
     *
     * @param user user whose balance must be checked
     * @throws InterruptedException exception, if there're troubles with thread
     */
    public void checkBalance(User user) throws InterruptedException {
        synchronized (bankAccount.getBankLock()) {
            synchronized (user.getUserLock()) {
                System.out.println(user.getName() + " checked his/her balance: "
                        + user.getUserBalance().longValue() + "\n");
                Thread.sleep(1000);
            }
        }
    }

    /**
     * Method for transferring money from {@paramref sender} to random reducer
     *
     * @param sender user who sends money
     * @param amount transfer amount
     * @throws InterruptedException exception, if there're troubles with thread
     */
    public void sendMoney(User sender, BigDecimal amount) throws InterruptedException {
        User receiver = ATMsimulation.getRandomUser(sender);
        synchronized (bankAccount.getBankLock()) {
            synchronized (sender.getUserLock()) {
                synchronized (receiver.getUserLock()) {
                    if (sender.isEnoughUserBalance(amount)) {
                        bankAccount.transferOperation(sender, receiver, amount);
                        System.out.println(sender.getName() + " transferred "
                                + amount.longValue() + " to " + receiver.getName());
                        System.out.println(sender.getName() + " balance " + sender.getUserBalance());
                        System.out.println(receiver.getName() + " balance " + receiver.getUserBalance() + "\n");
                    } else {
                        System.out.println("\u001B[31m" + sender.getName() + " can not send money to "
                                + receiver.getName() + "\u001B[0m");
                    }
                }
            }
        }
        Thread.sleep(1000);
    }
}
