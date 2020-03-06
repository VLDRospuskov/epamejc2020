package homework.ConcurrencyATM;

import java.math.BigDecimal;

public class User {

    private String name;
    private BigDecimal userAmount;

    public BigDecimal getUserAmount() {
        return userAmount;
    }

    public void setUserAmount(BigDecimal userAmount) {
        this.userAmount = userAmount;
    }

    public User(String name, BigDecimal userAmount) {
        this.name = name;
        this.userAmount = userAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}