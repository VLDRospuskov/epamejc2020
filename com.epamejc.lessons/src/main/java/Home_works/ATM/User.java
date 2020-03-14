package Home_works.ATM;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class User {

    private String name;
    private BigDecimal balanceOfUser;

    public User(String name, BigDecimal balanceOfUser) {
        this.name = name;
        this.balanceOfUser = balanceOfUser;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public void setBalanceOfUser(BigDecimal balanceOfUser) {
        this.balanceOfUser = balanceOfUser;
    }

    public BigDecimal getBalanceOfUser() {
        return balanceOfUser;
    }

}