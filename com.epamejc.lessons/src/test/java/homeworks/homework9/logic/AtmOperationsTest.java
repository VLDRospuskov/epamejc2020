package homeworks.homework9.logic;

import homeworks.homework9.data.ATM;
import homeworks.homework9.data.CentralStorage;
import lessons.lesson5.example1.A;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;

public class AtmOperationsTest {

    private static ATM atm;
    private static AtmOperations atmOperations;

    @BeforeClass
    public static void setUp() {
        atm = new ATM(BigDecimal.valueOf(250_000.00), 1);
        atmOperations = new AtmOperations(atm);
    }

    @Test
    public void testDepositOnly() {
        BigDecimal atmBalanceExpected1 = BigDecimal.valueOf(250_000.00);
        BigDecimal atmBalanceActual1 = atm.getAtmBalance();
        atmOperations.deposit(BigDecimal.valueOf(50_000.00));
        BigDecimal atmBalanceExpected2 = BigDecimal.valueOf(300_000.00);
        BigDecimal atmBalanceActual2 = atm.getAtmBalance();

        Assert.assertEquals(atmBalanceExpected1, atmBalanceActual1);
        Assert.assertEquals(atmBalanceExpected2, atmBalanceActual2);
    }

    @Test
    public void testDepositWithPuttingToReserve() {
        BigDecimal reserveAmount1 = CentralStorage.reserve;
        BigDecimal expectedReserveAmount1 = BigDecimal.valueOf(10_000_000.0);
        BigDecimal atmBalanceExpected1 = BigDecimal.valueOf(250_000.0);
        BigDecimal atmBalanceActual1 = atm.getAtmBalance();
        atmOperations.deposit(BigDecimal.valueOf(250_000.0));
        BigDecimal atmBalanceExpected2 = BigDecimal.valueOf(250_000.0);
        BigDecimal atmBalanceActual2 = atm.getAtmBalance();
        BigDecimal reserveAmount2 = CentralStorage.reserve;
        BigDecimal expectedReserveAmount2 = BigDecimal.valueOf(10_250_000.0);

        Assert.assertEquals(atmBalanceExpected1, atmBalanceActual1);
        Assert.assertEquals(atmBalanceExpected2, atmBalanceActual2);
        Assert.assertEquals(expectedReserveAmount1.intValue(), reserveAmount1.intValue());
        Assert.assertEquals(expectedReserveAmount2.intValue(), reserveAmount2.intValue());

    }

    @Test
    public void testWithdrawOnly() {
        BigDecimal atmBalanceExpected1 = BigDecimal.valueOf(250_000.00);
        BigDecimal atmBalanceActual1 = atm.getAtmBalance();
        atmOperations.withdraw(BigDecimal.valueOf(50_000.00));
        BigDecimal atmBalanceExpected2 = BigDecimal.valueOf(200_000.00);
        BigDecimal atmBalanceActual2 = atm.getAtmBalance();

        Assert.assertEquals(atmBalanceExpected1, atmBalanceActual1);
        Assert.assertEquals(atmBalanceExpected2, atmBalanceActual2);
    }

    @Test
    public void testWithDrawWithGettingFromReserve() {
        BigDecimal reserveAmount1 = CentralStorage.reserve;
        BigDecimal expectedReserveAmount1 = BigDecimal.valueOf(10_000_000.0);
        BigDecimal atmBalanceExpected1 = BigDecimal.valueOf(250_000.0);
        BigDecimal atmBalanceActual1 = atm.getAtmBalance();
        atmOperations.withdraw(BigDecimal.valueOf(150_000.0));
        BigDecimal atmBalanceExpected2 = BigDecimal.valueOf(250_000.0);
        BigDecimal atmBalanceActual2 = atm.getAtmBalance();
        BigDecimal reserveAmount2 = CentralStorage.reserve;
        BigDecimal expectedReserveAmount2 = BigDecimal.valueOf(9_850_000.0);

        Assert.assertEquals(atmBalanceExpected1, atmBalanceActual1);
        Assert.assertEquals(atmBalanceExpected2, atmBalanceActual2);
        Assert.assertEquals(expectedReserveAmount1.intValue(), reserveAmount1.intValue());
        Assert.assertEquals(expectedReserveAmount2.intValue(), reserveAmount2.intValue());
    }

}