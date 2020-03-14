package homeworks.java.multithreading;

/**
 * Program is an ATM usage simulation.
 * There are the bank, collector, users and ATMs as actors.
 * And there are separate threads for each user and the collector.
 * Users can deposit and withdraw cash, each user has own bank account and job,
 * collector collects ATMs.
 *
 * @author Vladimir Ivanov
 */
public class Main {

    public static void main(String[] args) {

        ATMSimulation simulation = new ATMSimulation();
        simulation.run();

    }

}
