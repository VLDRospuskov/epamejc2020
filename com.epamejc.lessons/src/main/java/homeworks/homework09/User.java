package homeworks.homework09;

import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.SneakyThrows;

import java.math.BigDecimal;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class User {

    public final String name;

    BigDecimal userBalance = new BigDecimal(100_000);

    public User(String name) {
        this.name = name;
    }

    @SneakyThrows
    public boolean executeOperation(int operation, BigDecimal amount, ATM atm) {
        synchronized (atm) {
            System.out.println(name + " occupied ATM №" + atm.id);
            TimeUnit.MILLISECONDS.sleep(2000 + new Random().nextInt(3000));
            boolean operationResult;
            switch (operation) {
                case 0:
                    operationResult = addToBalance(atm, amount);
                    System.out.println(name + " released ATM №" + atm.id);
                    return operationResult;
                case 1:
                    operationResult = takeFromBalance(atm, amount);
                    System.out.println(name + " released ATM №" + atm.id);
                    return operationResult;
                default:
                    return false;
            }
        }
    }

    public int chooseRandomOperation() {
        return new Random().nextInt(2);
    }

    public BigDecimal chooseRandomAmountFrom0To10000() {
        double random = new Random().nextDouble() * 10000;
        return new BigDecimal(random);
    }

    public boolean addToBalance(ATM atm, BigDecimal value) {
        if (this.userBalance.compareTo(value) < 0) {
            System.out.println(this.name + " doesn't have much money!");
            return false;
        } else {
            if (atm.addToBalance(value)) {
                userBalance = userBalance.add(value.negate());
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean takeFromBalance(ATM atm, BigDecimal value) {
        if (atm.subtractFromBalance(value)) {
            userBalance = userBalance.add(value);
            return true;
        } else {
            return false;
        }
    }

    public ATM chooseRandomATM() {
        int randomInt = new Random().nextInt(ATM_System.atmList.size());
        return ATM_System.atmList.get(randomInt);
    }


}
