package homework.homework9.atm;

import homework.homework9.util.Log;
import homework.homework9.util.RandomUtil;
import lombok.Getter;
import lombok.SneakyThrows;
import org.apache.commons.math3.util.Precision;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static homework.homework9.atm.AutomatedTellerMachine.*;

public class User {

    private final String name;
    @Getter
    private double cash;
    private List<AutomatedTellerMachine> atms;

    private Random random = new Random();

    public User(String name, double cash, List<AutomatedTellerMachine> atms) {
        this.name = name;
        this.cash = cash;
        this.atms = new ArrayList<>(atms);
    }

    public String getName() {
        return name;
    }

    public void putCash(double sum, AutomatedTellerMachine automatedTellerMachine) {
        Log.log(name + " wants to put cash " + Precision.round(sum, 2));

        if (cash >= sum) {
            cash -= sum;
            automatedTellerMachine.deposit(this, sum);
            Log.log(name + " succeeded. Users cash " + Precision.round(cash, 2));
        } else {
            Log.log(name + " doesn't have enough cash");
        }
    }

    public void takeCash(double sum, AutomatedTellerMachine automatedTellerMachine) {
        Log.log(name + " wants to get cash " + Precision.round(sum, 2));

        try {
            automatedTellerMachine.withdraw(this, sum);
            cash += sum;
            Log.log(name + " succeeded. Users cash " + Precision.round(cash, 2));
        } catch (IllegalStateException e) {
            Log.log(e.getMessage());
            Log.log(name + " failed");
        }
    }

    public double checkCash() {
        Log.log(name + " checked cash " + Precision.round(cash, 2));
        return cash;
    }

    @SneakyThrows
    public void performRandomTasks() {
        for (int i = 0; i < 10; i++) {
            double randomSum = RandomUtil.nextDoubleBetween(MIN_SUM, MAX_SUM);
            AutomatedTellerMachine randomATM = RandomUtil.randomElement(atms);

            switch (random.nextInt(OPERATIONS_COUNT)) {
                case 0:
                    putCash(randomSum, randomATM);
                    break;
                case 1:
                    takeCash(randomSum, randomATM);
                    break;
                case 2:
                    checkCash();
                    break;
            }

            Thread.sleep(1000);
        }
    }
}
