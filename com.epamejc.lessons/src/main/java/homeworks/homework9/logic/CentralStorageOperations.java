package homeworks.homework9.logic;

import java.math.BigDecimal;

import static homeworks.homework9.data.CentralStorage.reserve;

public class CentralStorageOperations {

    public static synchronized BigDecimal getFromReserve(BigDecimal amount) {
        if (reserve.subtract(amount).doubleValue() > 0.0) {
            reserve = reserve.subtract(amount);
            return amount;
        } else {
            return reserve;
        }
    }

    public static synchronized void putToReserve(BigDecimal amount) {
        reserve = reserve.add(amount);
    }

}
