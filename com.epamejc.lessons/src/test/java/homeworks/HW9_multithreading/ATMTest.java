package homeworks.HW9_multithreading;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class ATMTest {

    /**
     * Testing method {@link ATM#deposit(BigDecimal, User)} with enough user-balance value
     */
    @Test
    public void testDepositWithEnoughBalance() {
        long testAmount = 1000;
        long testUserBalance = 5000;
        BankAccount testBankAccount = new BankAccount(BigDecimal.valueOf(1_000_000));
        ATM testATM = new ATM(testBankAccount, 1);
        User testUser = new User("Vladimir", BigDecimal.valueOf(testUserBalance));
        try {
            testATM.deposit(BigDecimal.valueOf(testAmount), testUser);
        } catch (Exception ex) {
            System.err.println("Something wrong with thread");
        }
        long bankBalanceExpected = 1001000;
        long bankAccountActual = testBankAccount.getBankBalance();
        Assert.assertEquals(bankBalanceExpected, bankAccountActual);
    }

    /**
     * Testing method {@link ATM#deposit(BigDecimal, User)} without enough user-balance value
     */
    @Test
    public void testDepositWithoutEnoughBalance() {
        long testAmount = 2000;
        long testUserBalance = 1000;
        BankAccount testBankAccount = new BankAccount(BigDecimal.valueOf(1_000_000));
        ATM testATM = new ATM(testBankAccount, 1);
        User testUser = new User("Vladimir", BigDecimal.valueOf(testUserBalance));
        try {
            testATM.deposit(BigDecimal.valueOf(testAmount), testUser);
        } catch (Exception ex) {
            System.err.println("Something wrong with thread");
        }
        long bankBalanceExpected = 1000000;
        long bankAccountActual = testBankAccount.getBankBalance();
        Assert.assertEquals(bankBalanceExpected, bankAccountActual);
    }

    /**
     * Testing method {@link ATM#withdraw(BigDecimal, User)} with enough bank-balance
     */
    @Test
    public void testWithdrawWithEnoughBalance() {
        long testAmount = 100_000;
        long testUserBalance = 5000;
        long testBankBalance = 1_000_000;
        BankAccount testBankAccount = new BankAccount(BigDecimal.valueOf(testBankBalance));
        ATM testATM = new ATM(testBankAccount, 1);
        User testUser = new User("Vladimir", BigDecimal.valueOf(testUserBalance));
        try {
            testATM.withdraw(BigDecimal.valueOf(testAmount), testUser);
        } catch (Exception ex) {
            System.err.println("Something wrong with thread");
        }
        long bankBalanceExpected = 900_000;
        long bankAccountActual = testBankAccount.getBankBalance();
        Assert.assertEquals(bankBalanceExpected, bankAccountActual);
    }

    /**
     * Testing method {@link ATM#withdraw(BigDecimal, User)} without enough bank-balance
     */
    @Test
    public void testWithdrawWithoutEnoughBalance() {
        long testAmount = 100_000;
        long testUserBalance = 5000;
        long testBankBalance = 50_000;
        BankAccount testBankAccount = new BankAccount(BigDecimal.valueOf(testBankBalance));
        ATM testATM = new ATM(testBankAccount, 1);
        User testUser = new User("Vladimir", BigDecimal.valueOf(testUserBalance));
        try {
            testATM.withdraw(BigDecimal.valueOf(testAmount), testUser);
        } catch (Exception ex) {
            System.err.println("Something wrong with thread");
        }
        long bankBalanceExpected = 50_000;
        long bankAccountActual = testBankAccount.getBankBalance();
        Assert.assertEquals(bankBalanceExpected, bankAccountActual);
    }

    /**
     * Testing method {@link ATM#sendMoney(User, BigDecimal)} without enough payer-balance
     */
    @Test
    public void testSendMoneyWithoutEnoughBalance() {
        long payerUserBalance = 1000;
        long testAmount = 5000;
        BankAccount testBankAccount = new BankAccount(BigDecimal.valueOf(1_000_000));
        ATM testATM = new ATM(testBankAccount, 1);
        ATMsimulation atMsimulation = new ATMsimulation();
        User payer = new User("Vladimir", BigDecimal.valueOf(payerUserBalance));
        User receiver = ATMsimulation.getRandomUser(payer);
        long receiverUserBalanceExpected = receiver.getUserBalance().longValue();
        try {
            testATM.sendMoney(payer, BigDecimal.valueOf(testAmount));
        } catch (Exception ex) {
            System.err.println("Something wrong with thread");
        }
        long receiverUserBalanceActual = receiver.getUserBalance().longValue();
        Assert.assertEquals(receiverUserBalanceExpected, receiverUserBalanceActual);
    }
}