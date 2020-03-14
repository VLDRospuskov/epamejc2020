package homeworks.homework9.data;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ATM {

    private BigDecimal atmBalance;
    private int id;

}
