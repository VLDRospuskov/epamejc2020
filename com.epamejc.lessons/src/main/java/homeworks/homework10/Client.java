package homeworks.homework10;

import java.math.BigDecimal;

public class Client {
    
    private BigDecimal accountMoney;
    private String name;
    
    public Client(BigDecimal accountMoney, String name) {
        this.accountMoney = accountMoney;
        this.name = name;
    }
    
    public BigDecimal getAccountMoney() {
        return accountMoney;
    }
    
    public void setAccountMoney(BigDecimal accountMoney) {
        this.accountMoney = accountMoney;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
}
