package homework.ConcurrencyATM;

import java.math.BigDecimal;

public class ATM {
    private BigDecimal ATMBalance;
    private static BigDecimal CommonBalance;
    final private int ID;

    public int getID() {
        return ID;
    }

    public ATM(int ID, BigDecimal ATMBalance) {
        this.ATMBalance = ATMBalance;
        this.ID = ID;
    }

    public BigDecimal getATMBalance() {
        return ATMBalance;
    }

    public synchronized void setATMBalance(BigDecimal ATMBalance) {
        this.ATMBalance = ATMBalance;
    }

    public static BigDecimal getCommonBalance() {
        return CommonBalance;
    }

    public static synchronized void setCommonBalance(BigDecimal commonBalance) {
        CommonBalance = commonBalance;
    }

    public synchronized BigDecimal deposit(BigDecimal amount) {
        System.out.println("User name: " + Thread.currentThread().getName() + " deposit: " + amount);
        printBalance();
        return ATMBalance = ATMBalance.add(amount);
    }

    public synchronized boolean withdraw(BigDecimal amount) {
        if (amount.compareTo(this.ATMBalance) > 0) {
            System.out.println("Not enough mana");
            return false;
        } else {
            System.out.println("User name: " + Thread.currentThread().getName() + " withdraw: " + amount);
            printBalance();
            ATMBalance = ATMBalance.subtract(amount);
            return true;
        }
    }

    private void printBalance() {
        System.out.printf("ATM %d balance: " + getATMBalance() + "\n", getID());
    }

    public synchronized void checkBalance() {
        System.out.println("User name: " + Thread.currentThread().getName() +
                           ", your current balance: " +
                                ((ThreadATMOperations)Thread.currentThread()).getUser().getUserAmount());
        printBalance();
    }

    public synchronized void sendMoneyToAnotherUser(User receiver, BigDecimal amount){
        receiver.setUserAmount(receiver.getUserAmount().add(amount));
        User userSender = ((ThreadATMOperations)Thread.currentThread()).getUser();
        userSender.setUserAmount(userSender.getUserAmount().subtract(amount));
        System.out.println("User name: " + Thread.currentThread().getName() + ", you sent " + amount + " to " + receiver.getName());
        System.out.println("Your balance now " + userSender.getUserAmount());
    }
}