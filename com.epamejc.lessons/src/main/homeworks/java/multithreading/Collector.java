package homeworks.java.multithreading;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Collector {

    private List<ATM> atms;

    public Collector(List<ATM> atms) {

        super();
        this.atms = atms;

    }

    /**
     * Used for service operation.
     * ATM balance after it must be equal to 500_000, so
     * it calculates the difference between 500_000 and current
     * ATM balance. This difference can be positive or negative
     * and passed as a parameter to {@link ATM#service(BigDecimal)}
     */
    public void service(ATM atm) {

        BigDecimal cash = BigDecimal.valueOf(500_000.0);
        BigDecimal difference = cash.subtract(atm.getAccount());
        Bank.getInstance().serviceOperation(atm.getAccount());
        atm.service(difference);

    }

}
