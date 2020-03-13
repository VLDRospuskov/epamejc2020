package ATM;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ATM {

    private BigDecimal balanceOfATM;
    private static BigDecimal _commonBalance;
    private int id;

    public ATM(int id, BigDecimal balanceOfATM) {
        this.balanceOfATM = balanceOfATM;
        this.id = id;
    }

    public BigDecimal getBalanceOfATM() {
        return balanceOfATM;
    }

    public synchronized void setBalanceOfATM(BigDecimal balanceOfATM) {
        this.balanceOfATM = balanceOfATM;
    }

    public static BigDecimal getCommonBalance() {
        return _commonBalance;
    }

    public static synchronized void setCommonBalance(BigDecimal commonBalance) {
        _commonBalance = commonBalance;
    }

    public int getId() {
        return id;
    }

    public synchronized BigDecimal deposit(BigDecimal amount) {
        System.out.println("User name: " + Thread.currentThread().getName() + " deposit: " + amount);
        System.out.printf("ATM %d balance: " + getBalanceOfATM() + "\n", getId());

        return balanceOfATM = balanceOfATM.add(amount);
    }

    public synchronized boolean withdraw(BigDecimal amount) {
        if (amount.compareTo(this.balanceOfATM) > 0) {
            System.out.println("Sorry, don't enough money.");
            return false;
        } else {
            System.out.println("User name: " + Thread.currentThread().getName() + " withdraw: " + amount);
            System.out.printf("ATM %d balance: " + getBalanceOfATM() + "\n", getId());
            balanceOfATM = balanceOfATM.subtract(amount);
            return true;
        }
    }

    public synchronized void checkBalanceOfUser() {
        System.out.println("User name: " + Thread.currentThread().getName() +
                ", your current balance: " +
                ((ThreadATMOperations) Thread.currentThread()).getUser().getBalanceOfUser());
        System.out.printf("ATM %d balance: " + getBalanceOfATM() + "\n", getId());
    }
}
