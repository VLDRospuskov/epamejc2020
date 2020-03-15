package homeworks.homework09;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class MultiThreadingTest {

    @Test
    public void testBalanceGoodWithdrawal() {
        BigDecimal expected = Balance.getBalance()
                .add(BigDecimal
                        .valueOf(20_000.5)
                        .negate());

        Balance.subtractFromBalance(BigDecimal.valueOf(20_000.5));

        BigDecimal actual = Balance.getBalance();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testBalanceOverWithdraw() {
        Balance.setBalance(BigDecimal.valueOf(200_000));

        BigDecimal expected = Balance.getBalance();

        Balance.subtractFromBalance(BigDecimal.valueOf(200_000.5));
        BigDecimal actual = Balance.getBalance();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testBalanceDeposit() {
        BigDecimal expected = Balance.getBalance()
                .add(BigDecimal.valueOf(20_000.5));

        Balance.addToBalance(BigDecimal.valueOf(20_000.5));
        BigDecimal actual = Balance.getBalance();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAtmGoodDeposit() {
        Balance.setBalance(BigDecimal.valueOf(200_000));
        ATM atm = new ATM(1);

        BigDecimal expected = BigDecimal.valueOf(300_000);

        atm.addToBalance(BigDecimal.valueOf(100_000));

        BigDecimal actual = atm.getAtmBalance();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAtmOverDeposit() {
        Balance.setBalance(BigDecimal.valueOf(200_000));
        ATM atm = new ATM(1);

        BigDecimal expectedAtmBalance = ATM.DEFAULT_BALANCE;
        BigDecimal expectedGlobalBalance = BigDecimal.valueOf(300_000);

        atm.addToBalance(BigDecimal.valueOf(300_000));

        BigDecimal actualAtmBalance = atm.getAtmBalance();
        BigDecimal actualGlobalBalance = Balance.getBalance();

        Assert.assertEquals(expectedAtmBalance, actualAtmBalance);
        Assert.assertEquals(expectedGlobalBalance, actualGlobalBalance);
    }

    @Test
    public void testAtmGoodWithdraw() {
        Balance.setBalance(BigDecimal.valueOf(200_000));
        ATM atm = new ATM(1);

        BigDecimal expected = BigDecimal.valueOf(100_000);

        atm.subtractFromBalance(BigDecimal.valueOf(100_000));

        BigDecimal actual = atm.getAtmBalance();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAtmOverWithdraw() {
        ATM atm = new ATM(1);

        BigDecimal expected = atm.getAtmBalance();

        atm.subtractFromBalance(BigDecimal.valueOf(300_000));

        BigDecimal actual = atm.getAtmBalance();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAtmBelowMinimumWithdraw() {
        Balance.setBalance(BigDecimal.valueOf(500_000));
        ATM atm = new ATM(1);

        BigDecimal expectedAtmBalance = ATM.DEFAULT_BALANCE;
        BigDecimal expectedGlobalBalance = BigDecimal.valueOf(140_000);

        atm.subtractFromBalance(BigDecimal.valueOf(160_000));

        BigDecimal actualAtmBalance = atm.getAtmBalance();
        BigDecimal actualGlobalBalance = Balance.getBalance();

        Assert.assertEquals(expectedAtmBalance, actualAtmBalance);
        Assert.assertEquals(expectedGlobalBalance, actualGlobalBalance);
    }

    @Test
    public void testAllAtmBalance() {
        Balance.setBalance(BigDecimal.valueOf(600_000));

        BigDecimal expected = BigDecimal.valueOf(600_000);
        BigDecimal actual = ATM_System.getAllAtmBalance();

        Assert.assertEquals(expected, actual);
    }

}
