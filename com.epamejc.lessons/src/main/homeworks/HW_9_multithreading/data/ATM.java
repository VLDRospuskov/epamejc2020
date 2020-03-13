package homeworks.HW_9_multithreading.data;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ATM {

    private BigDecimal balance;
    private String location;

}
