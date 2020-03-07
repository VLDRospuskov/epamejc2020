package homeworks.homework9_multithreading.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Account {
    private final Long card;
    private BigDecimal balance;
}
