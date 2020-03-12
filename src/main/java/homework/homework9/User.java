package homework.homework9;

import lombok.SneakyThrows;
import org.apache.commons.math3.util.Precision;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static homework.homework9.AutomatedTellerMachine.*;

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
        System.out.println(name + " wants to put cash " + sum);

        if (cash >= sum) {
            cash -= sum;
            automatedTellerMachine.deposit(this, sum);
            System.out.println(name + " succeeded. Users cash " + cash);
        } else {
            System.out.println(name + " doesn't have enough cash");
        }
    }

    public void getCash(double sum, AutomatedTellerMachine automatedTellerMachine) {
        System.out.println(name + " wants to get cash " + sum);

        automatedTellerMachine.withdraw(this, sum);
        cash += sum;
        System.out.println(name + " succeeded. Users cash " + cash);
    }

    public double checkCash() {
        System.out.println(name + " checked cash " + cash);
        return cash;
    }

    @SneakyThrows
    public void performRandomTasks() {
        while (true) {
            int randomOperation = 1 + random.nextInt(OPERATIONS_COUNT);
            double randomSum = MIN_SUM + (MAX_SUM - MIN_SUM) * Precision.round(random.nextDouble(), 2);
            AutomatedTellerMachine randomATM = atms.get(random.nextInt(atms.size()));

            if (randomOperation % 2 == 0) {
                putCash(randomSum, randomATM);
            } else if (randomOperation % 3 == 0) {
                getCash(randomSum, randomATM);
            } else {
                checkCash();
            }

            Thread.sleep(3000);
        }
    }
}
