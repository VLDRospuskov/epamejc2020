package homeworks.homework08.part1;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class CreditCard {
    private int cardNumber;
    private BigDecimal balance;
    private int CVV;
}
