package homeworks.homework9;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class User {

    private String name;
    private BigDecimal cashBalance;
    private BigDecimal accountBalance;

}
