package homeworks.java.multithreading;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CollectorTest {

    @Test
    public void testService() {

        BigDecimal expectedATMBalance = BigDecimal.valueOf(500_000.);
        BigDecimal expectedBankBalance = BigDecimal.valueOf(1_500_000.);

        Bank bank = Bank.getInstance();
        List<ATM> atms = new ArrayList<>();
        ATM atm = new ATM(15);
        atms.add(atm);
        Collector collector = new Collector(atms);
        collector.service(atm);
        BigDecimal actualATMBalance = atm.getAccount();
        BigDecimal actualBankBalance = bank.getMoneyStash();

        Assert.assertEquals(expectedATMBalance, actualATMBalance);
        Assert.assertEquals(expectedBankBalance, actualBankBalance);

    }

}
