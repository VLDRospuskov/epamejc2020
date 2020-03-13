package homeworks.HW_9_multithreading.data;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class User {

    private BigDecimal cashBalance;
    private BigDecimal accountBalance;
    private String name;

}
