package homeworks.java.multithreading;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ATMTest {

    private ATM atm;
    private User user;

    @Before
    public void setUp() {

        atm = new ATM(15);
        user = new User("Pupkin", 600, 600);
        Bank.getInstance().registerUser(user);

    }

    @Test
    public void testServiceAccountPositive() {

        BigDecimal expected = BigDecimal.valueOf(500_500.);

        BigDecimal amount = BigDecimal.valueOf(500);
        atm.service(amount);
        BigDecimal actual = atm.getAccount();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testServiceAccountNegative() {

        BigDecimal expected = BigDecimal.valueOf(499_500.);

        BigDecimal amount = BigDecimal.valueOf(-500);
        atm.service(amount);
        BigDecimal actual = atm.getAccount();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testServiceIsOnService() {

        BigDecimal amount = BigDecimal.valueOf(100);
        atm.setOnService(true);
        atm.service(amount);

        Assert.assertFalse(atm.isOnService());

    }

    @Test
    public void testDepositIsOnService() {

        BigDecimal expectedATMAccount = BigDecimal.valueOf(500_000.);
        BigDecimal expectedUserCash = BigDecimal.valueOf(600);

        BigDecimal amount = BigDecimal.valueOf(500);
        atm.setOnService(true);
        atm.deposit(amount, user);

        Assert.assertEquals(expectedATMAccount, atm.getAccount());
        Assert.assertEquals(expectedUserCash, user.getCash());

    }

    @Test
    public void testDepositIsNotOnService() {

        BigDecimal expectedATMAccount = BigDecimal.valueOf(500_500.);
        BigDecimal expectedUserCash = BigDecimal.valueOf(100);

        BigDecimal amount = BigDecimal.valueOf(500);
        atm.deposit(amount, user);

        Assert.assertEquals(expectedATMAccount, atm.getAccount());
        Assert.assertEquals(expectedUserCash, user.getCash());

    }

    @Test
    public void testWithdrawIsOnService() {

        BigDecimal expectedATMAccount = BigDecimal.valueOf(500_000.);
        BigDecimal expectedUserCash = BigDecimal.valueOf(600);

        BigDecimal amount = BigDecimal.valueOf(500);
        atm.setOnService(true);
        atm.withdraw(amount, user);

        Assert.assertEquals(expectedATMAccount, atm.getAccount());
        Assert.assertEquals(expectedUserCash, user.getCash());

    }

    @Test
    public void testWithdrawNotEnoughCashATM() {

        BigDecimal expectedATMAccount = BigDecimal.valueOf(500_000.);
        BigDecimal expectedUserCash = BigDecimal.valueOf(600);

        BigDecimal amount = BigDecimal.valueOf(500_500.);
        atm.withdraw(amount, user);

        Assert.assertEquals(expectedATMAccount, atm.getAccount());
        Assert.assertEquals(expectedUserCash, user.getCash());

    }

    @Test
    public void testWithdrawNotEnoughFundsOnUserAccount() {

        BigDecimal expectedATMAccount = BigDecimal.valueOf(500_000.);
        BigDecimal expectedUserCash = BigDecimal.valueOf(600);

        BigDecimal amount = BigDecimal.valueOf(500);
        atm.withdraw(amount, user);

        Assert.assertEquals(expectedATMAccount, atm.getAccount());
        Assert.assertEquals(expectedUserCash, user.getCash());

    }

    @Test
    public void testWithdrawSuccess() {

        BigDecimal expectedATMAccount = BigDecimal.valueOf(499_500.);
        BigDecimal expectedUserCash = BigDecimal.valueOf(1100);

        BigDecimal amount = BigDecimal.valueOf(500);

        Bank.getInstance().userAccountUpdate(user, BigDecimal.valueOf(600));
        atm.withdraw(amount, user);

        Assert.assertEquals(expectedATMAccount, atm.getAccount());
        Assert.assertEquals(expectedUserCash, user.getCash());

    }

}
