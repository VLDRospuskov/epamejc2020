package homeworks.homework9.logic;

import homeworks.homework9.data.User;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class UserOperationsTest {

    private static User user;
    private static UserOperations userOperations;

    @BeforeClass
    public static void setup() {
        user = new User("Serj", BigDecimal.valueOf(500.00), BigDecimal.valueOf(20_000.00));
        userOperations = new UserOperations(user);
    }

    @Test
    public void checkCashBalance() {
        boolean isCashBalanceExpected1 = true;
        boolean isCashBalanceActual1 = userOperations.checkCashBalance(BigDecimal.valueOf(0.0));

        boolean isCashBalanceExpected2 = false;
        boolean isCashBalanceActual2 = userOperations.checkCashBalance(BigDecimal.valueOf(500.00));

        Assert.assertEquals(isCashBalanceExpected1, isCashBalanceActual1);
        Assert.assertEquals(isCashBalanceExpected2, isCashBalanceActual2);

    }

    @Test
    public void checkAccountBalance() {
        boolean isAccountBalanceExpected1 = true;
        boolean isAccountBalanceActual1 = userOperations.checkCashBalance(BigDecimal.valueOf(0.0));

        boolean isAccountBalanceExpected2 = false;
        boolean isAccountBalanceActual2 = userOperations.checkCashBalance(BigDecimal.valueOf(20_000.00));

        Assert.assertEquals(isAccountBalanceExpected1, isAccountBalanceActual1);
        Assert.assertEquals(isAccountBalanceExpected2, isAccountBalanceActual2);
    }

    @Test
    public void deposit() {
        BigDecimal actualCashBalance = user.getCashBalance();
        BigDecimal expectedCashBalance = BigDecimal.valueOf(500.00);
        BigDecimal actualAccountBalance = user.getAccountBalance();
        BigDecimal expectedAccountBalance = BigDecimal.valueOf(20_000.00);

        userOperations.deposit(actualCashBalance);

        BigDecimal actualCashBalance2 = user.getCashBalance();
        BigDecimal expectedCashBalance2 = BigDecimal.valueOf(0.00);
        BigDecimal actualAccountBalance2 = user.getAccountBalance();
        BigDecimal expectedAccountBalance2 = BigDecimal.valueOf(20_500.00);

        Assert.assertEquals(expectedCashBalance, actualCashBalance);
        Assert.assertEquals(expectedCashBalance2, actualCashBalance2);
        Assert.assertEquals(expectedAccountBalance, actualAccountBalance);
        Assert.assertEquals(expectedAccountBalance2, actualAccountBalance2);
    }

    @Test
    public void withdraw() {
        BigDecimal actualCashBalance = user.getCashBalance();
        BigDecimal expectedCashBalance = BigDecimal.valueOf(500.00);
        BigDecimal actualAccountBalance = user.getAccountBalance();
        BigDecimal expectedAccountBalance = BigDecimal.valueOf(20_000.00);

        userOperations.withdraw(actualAccountBalance);

        BigDecimal actualCashBalance2 = user.getCashBalance();
        BigDecimal expectedCashBalance2 = BigDecimal.valueOf(20_500.00);
        BigDecimal actualAccountBalance2 = user.getAccountBalance();
        BigDecimal expectedAccountBalance2 = BigDecimal.valueOf(0.00);

        Assert.assertEquals(expectedCashBalance, actualCashBalance);
        Assert.assertEquals(expectedCashBalance2, actualCashBalance2);
        Assert.assertEquals(expectedAccountBalance, actualAccountBalance);
        Assert.assertEquals(expectedAccountBalance2, actualAccountBalance2);
    }
}