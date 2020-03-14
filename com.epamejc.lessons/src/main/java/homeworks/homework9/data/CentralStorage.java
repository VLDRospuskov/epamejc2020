package homeworks.homework9.data;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
public class CentralStorage {

    public volatile static BigDecimal reserve = BigDecimal.valueOf(5_000_000_000.00);

}
