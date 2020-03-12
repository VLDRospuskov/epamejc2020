package homework.homework9.atm;

import homework.homework9.util.Log;
import lombok.SneakyThrows;
import org.apache.commons.math3.util.Precision;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static homework.homework9.atm.AutomatedTellerMachine.*;

public class User {

    private final String name;
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
        Log.log(name + " wants to put cash " + sum);

        if (cash >= sum) {
            cash -= sum;
            automatedTellerMachine.deposit(this, sum);
            Log.log(name + " succeeded. Users cash " + cash);
        } else {
            Log.log(name + " doesn't have enough cash");
        }
    }

    public void getCash(double sum, AutomatedTellerMachine automatedTellerMachine) {
        Log.log(name + " wants to get cash " + sum);

        automatedTellerMachine.withdraw(this, sum);
        cash += sum;
        Log.log(name + " succeeded. Users cash " + cash);
    }

    public double checkCash() {
        Log.log(name + " checked cash " + cash);
        return cash;
    }

    @SneakyThrows
    public void performRandomTasks() {
        while (true) {
            double randomSum = MIN_SUM + (MAX_SUM - MIN_SUM) * Precision.round(random.nextDouble(), 2);
            AutomatedTellerMachine randomATM = atms.get(random.nextInt(atms.size()));

            switch (random.nextInt(OPERATIONS_COUNT)) {
                case 0:
                    putCash(randomSum, randomATM);
                    break;
                case 1:
                    getCash(randomSum, randomATM);
                    break;
                case 2:
                    checkCash();
                    break;
            }

            Thread.sleep(3000);
        }
    }
}
