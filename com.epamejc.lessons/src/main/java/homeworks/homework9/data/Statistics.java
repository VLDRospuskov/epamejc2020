package homeworks.homework9.data;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Statistics {

    public volatile int depositTimes;
    public volatile BigDecimal depositedAmount;
    public volatile int withdrawTimes;
    public volatile BigDecimal withdrawAmount;
    public volatile BigDecimal reserveBeforeChanged;
    public volatile BigDecimal reserveAfterChanged;
    public volatile int putToReserveTimes;
    public volatile BigDecimal putToReserveAmount;
    public volatile int getFromReserveTimes;
    public volatile BigDecimal getFromReserveAmount;

    public Statistics() {
        reserveBeforeChanged = CentralStorage.reserve;
        depositedAmount = BigDecimal.valueOf(0);
        withdrawAmount = BigDecimal.valueOf(0);
        putToReserveAmount = BigDecimal.valueOf(0);
        getFromReserveAmount = BigDecimal.valueOf(0);
        reserveAfterChanged = BigDecimal.valueOf(0);
    }

}
