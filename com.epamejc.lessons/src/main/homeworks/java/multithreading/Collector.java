package homeworks.java.multithreading;

import java.math.BigDecimal;
import java.util.List;

public class Collector extends Person implements Runnable {

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

    @Override
    public void run() {

        while (true) {
            for (ATM atm : atms) {
                if (atm.isOnService()) {
                    service(atm);
                }
            }

        }

    }

}
