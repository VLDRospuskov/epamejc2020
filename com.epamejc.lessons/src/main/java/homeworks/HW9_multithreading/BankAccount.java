package homeworks.HW9_multithreading;

import java.math.BigDecimal;

public class BankAccount {

    private volatile BigDecimal bankBalance;
    private final Object bankLock = new Object();

    public BankAccount(BigDecimal bankBalance) {
        this.bankBalance = bankBalance;
    }

    public synchronized Object getBankLock() {
        return this.bankLock;
    }

    public void increaseBankBalance(BigDecimal amount) {
        synchronized (bankLock) {
            bankBalance = bankBalance.add(amount);
        }
    }

    public void decreaseBankBalance(BigDecimal amount) {
        synchronized (bankLock) {
            bankBalance = bankBalance.subtract(amount);
        }
    }

    public long getBankBalance() {
        synchronized (bankLock) {
            return bankBalance.longValue();
        }
    }

    public boolean isEnoughBankBalance(BigDecimal amount) {
        synchronized (bankLock) {
            return amount.compareTo(bankBalance) == -1 || amount.compareTo(bankBalance) == 0;
        }
    }

    public void transferOperation(User payer, User receiver, BigDecimal amount) {
        payer.decreaseUserBalance(amount);
        receiver.increaseUserBalance(amount);
    }
}
