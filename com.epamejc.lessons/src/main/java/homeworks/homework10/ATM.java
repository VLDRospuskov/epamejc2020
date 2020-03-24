package homeworks.homework10;

import java.math.BigDecimal;

public class ATM {
    
    private static BigDecimal globalBalance;
    private BigDecimal ATMBalance;
    private int ID;
    
    public ATM(int ID, BigDecimal ATMBalance) {
        this.ATMBalance = ATMBalance;
        this.ID = ID;
    }
    
    public static BigDecimal getGlobalBalance() {
        return globalBalance;
    }
    
    public synchronized static void setGlobalBalance(BigDecimal globalBalance) {
        ATM.globalBalance = globalBalance;
    }
    
    public BigDecimal getATMBalance() {
        return ATMBalance;
    }
    
    public synchronized void setATMBalance(BigDecimal ATMBalance) {
        this.ATMBalance = ATMBalance;
    }
    
    public synchronized void checkClientAndATMBalance() {
        System.out.println("Balance " + Thread.currentThread()
                                              .getName() + ": " + ((ThreadOperations) Thread.currentThread())
                                                                          .getClient()
                                                                          .getAccountMoney());
        System.out.println("ATM " + getID() + ": " + getATMBalance());
    }
    
    public synchronized void deposit(BigDecimal depositSize) {
        System.out.println(Thread.currentThread()
                                 .getName() + " deposit size " + depositSize);
        ATMBalance = ATMBalance.add(depositSize);
        checkClientAndATMBalance();
    }
    
    public synchronized boolean withdraw(BigDecimal withdrawSize) {
        if (withdrawSize.compareTo(getATMBalance()) > 0) {
            System.out.println("Insufficient funds");
            return false;
        } else {
            System.out.println(Thread.currentThread()
                                     .getName() + " withdraw size " + withdrawSize);
            ATMBalance = this.ATMBalance.subtract(withdrawSize);
            checkClientAndATMBalance();
            return true;
        }
    }
    
    private int getID() {
        return ID;
    }
    
}
