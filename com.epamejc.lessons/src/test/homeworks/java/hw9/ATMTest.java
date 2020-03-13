package homeworks.java.hw9;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ATMTest {
    Customer testUser;
    ATM atm;

    @Before
    public void setUp() {
        GeneralBalance.commonATMBalance = 1000;
        testUser = new Customer("TestUser", 500);
        atm = new ATM("TestATM");
    }

    @Test
    public void testDepositWithValidAmount() {
        int amount = 350;
        final int expectedATMBalance = 1350;
        int actualATMBalance = atm.deposit(amount, testUser);
        Assert.assertEquals(expectedATMBalance, actualATMBalance);
    }

    @Test(expected = RuntimeException.class)
    public void testDepositWithInvalidAmount() {
        int amount = 600;
        atm.deposit(amount, testUser);
    }

    @Test
    public void testWithdrawWithValidAmount() {
        int amount = 700;
        final int expectedATMBalance = 300;
        int actualATMBalance = atm.withdraw(amount,testUser);
        Assert.assertEquals(expectedATMBalance, actualATMBalance);
    }

    @Test(expected = RuntimeException.class)
    public void testWithdrawWithInvalidAmount() {
        int amount = 1100;
        atm.withdraw(amount, testUser);
    }
}