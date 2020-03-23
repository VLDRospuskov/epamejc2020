package homeworks.java.multithreading;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class BankTest {

    @Before
    public void setUp() {

        Bank.getInstance().deleteAllUsers();

    }

    @After
    public void restore() {

        Bank.getInstance().setMoneyStash(BigDecimal.valueOf(1_000_000.));

    }

    @Test
    public void testRegisterDifferentUsers() {

        Bank bank = Bank.getInstance();
        bank.registerUser(new User("Tom", 100., 100.));
        bank.registerUser(new User("Jerry", 200., 200.));

        Assert.assertEquals(2, Bank.getInstance().getUserAccounts().size());

    }

    @Test
    public void testRegisterEqualUsers() {

        Bank bank = Bank.getInstance();
        User user = new User("Harold", 300., 300.);
        bank.registerUser(user);
        bank.registerUser(user);

        Assert.assertEquals(1, Bank.getInstance().getUserAccounts().size());

    }

    @Test
    public void testGetUserAccountDetailsExistingUser() {

        BigDecimal expected = BigDecimal.valueOf(500.);

        Bank bank = Bank.getInstance();
        User user = new User("Gleb", 1000., 1000.);
        bank.registerUser(user);
        bank.userAccountUpdate(user, BigDecimal.valueOf(500.));
        BigDecimal actual = bank.getUserAccountDetails(user);

        Assert.assertEquals(expected, actual);

    }

    @Test(expected = RuntimeException.class)
    public void testGetUserAccountDetailsMissingUser() {

        User user1 = new User("Margaret", 10_000., 999_999.);
        User user2 = new User("Magomet", 10., 100.);
        Bank bank = Bank.getInstance();
        bank.registerUser(user1);
        bank.getUserAccountDetails(user2);

    }

    @Test
    public void testUserAccountUpdatePositive() {

        User user = new User("Gordon Freeman", 1_000., 100_000.);
        Bank.getInstance().registerUser(user);
        Assert.assertTrue(Bank.getInstance().userAccountUpdate(user, BigDecimal.valueOf(500.)));

    }

    @Test
    public void testUserAccountUpdateNegative() {

        User user = new User("Gordon Freeman", 1_000., 100_000.);
        Bank.getInstance().registerUser(user);
        Bank.getInstance().userAccountUpdate(user, BigDecimal.valueOf(600.));
        Assert.assertTrue(Bank.getInstance().userAccountUpdate(user, BigDecimal.valueOf(-500.)));

    }

    @Test
    public void testUserAccountUpdateFalse() {

        User user = new User("Gordon Freeman", 1_000., 100_000.);
        Bank.getInstance().registerUser(user);
        Assert.assertFalse(Bank.getInstance().userAccountUpdate(user, BigDecimal.valueOf(-500.)));

    }

    @Test
    public void testTransferSalary() {

        BigDecimal expected = BigDecimal.valueOf(1000);

        User user = new User("Steve", 10., 1000.);
        Bank.getInstance().registerUser(user);
        Bank.getInstance().transferSalary(user);
        BigDecimal actual = Bank.getInstance().getUserAccountDetails(user);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testServicePositive() {

        BigDecimal expected = BigDecimal.valueOf(1_000_500.);

        Bank.getInstance().serviceOperation(BigDecimal.valueOf(500.));
        BigDecimal actual = Bank.getInstance().getMoneyStash();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testServiceNegative() {

        BigDecimal expected = BigDecimal.valueOf(999_500.);

        Bank.getInstance().serviceOperation(BigDecimal.valueOf(-500.));
        BigDecimal actual = Bank.getInstance().getMoneyStash();

        Assert.assertEquals(expected, actual);

    }

    @Test(expected = RuntimeException.class)
    public void testServiceBankrupted() {

        Bank.getInstance().serviceOperation(BigDecimal.valueOf(-1_500_000.));

    }

}
