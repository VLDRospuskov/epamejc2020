package homeworks.java.multithreading;

import lombok.SneakyThrows;

import java.math.BigDecimal;
import java.util.List;

public class Collector implements Runnable {

    private List<ATM> atms;
    public Collector(List<ATM> atms) {

        super();
        this.atms = atms;

    }

    private void service(ATM atm) {

        BigDecimal cash = BigDecimal.valueOf(500_000.0);
        BigDecimal difference = cash.subtract(atm.getAccount());
        atm.service(difference);
        Bank bank = Bank.getInstance();
        bank.serviceOperation(difference);

    }

    @SneakyThrows
    @Override
    public void run() {

        while (true) {
            Thread.sleep(2000L);
            for (ATM atm : atms) {
                if (atm.isOnService()) {
                    service(atm);
                }
            }

        }

    }

}
