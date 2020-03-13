package homeworks.HW_9_multithreading.logic;

import homeworks.HW_9_multithreading.data.ATM;
import homeworks.HW_9_multithreading.data.User;
import lombok.SneakyThrows;

import java.math.BigDecimal;
import java.util.ArrayList;

import static homeworks.HW_9_multithreading.logic.OperationsThread.*;
import static homeworks.HW_9_multithreading.data.Counter.*;

public class BankingApplication {

    @SneakyThrows
    public void run() {
        initialize();

        final OperationsThread thread1 = new OperationsThread();
        final OperationsThread thread2 = new OperationsThread();
        final OperationsThread thread3 = new OperationsThread();
        final OperationsThread thread4 = new OperationsThread();
        final OperationsThread thread5 = new OperationsThread();

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        thread5.join();

        printStatistics();
    }

    private void printStatistics() {
        System.out.println("Total operations: " + (withdrawals + deposits) + ", declines: " +
                (declinedATM + declinedCash + declinedAccount));
        System.out.println("Withdrawals: " + withdrawals + ", deposits: " + deposits);
        System.out.println("DeclinedATM: " + declinedATM + ", declinedAccount: " + declinedAccount +
                ", declinedCash: " + declinedCash);
    }


    private void initialize() {
        users = new ArrayList<>();
        users.add(new User(BigDecimal.valueOf(14500.00), BigDecimal.valueOf(2000.00), "Stepan Razin"));
        users.add(new User(BigDecimal.valueOf(12740.00), BigDecimal.valueOf(4000.00), "Petr Kosovoi"));
        users.add(new User(BigDecimal.valueOf(8745.34), BigDecimal.valueOf(5000.00), "Matrena Ivanova"));
        users.add(new User(BigDecimal.valueOf(5262.55), BigDecimal.valueOf(10000.00), "Oleg Shinvali"));
        users.add(new User(BigDecimal.valueOf(315.16), BigDecimal.valueOf(20000.00), "Diana Terezova"));

        atms = new ArrayList<>();
        atms.add(new ATM(BigDecimal.valueOf(3000.00), "Prospect Prosveshenia 12a"));
        atms.add(new ATM(BigDecimal.valueOf(4000.00), "Ulitsa Dobrolubova 44"));
        atms.add(new ATM(BigDecimal.valueOf(5000.00), "Krasnii Prospect 8"));
    }

}
