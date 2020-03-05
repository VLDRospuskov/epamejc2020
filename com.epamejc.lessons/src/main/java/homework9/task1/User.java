package homework9.task1;


import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

@Data
class User {

    String name;
    BigDecimal userBalance;

    User(String name) {
        this.name = name;
        this.userBalance = generateRandomUserBalance();
        System.out.println(this.name + " has " + this.userBalance + " in cash.");
    }

    private BigDecimal generateRandomUserBalance() {
        return BigDecimal.valueOf(new Random().nextDouble() * 100_000).setScale(2, RoundingMode.CEILING);
    }
}
