package homeworks.HW_9_multithreading.logic;

import homeworks.HW_9_multithreading.data.ATM;
import homeworks.HW_9_multithreading.data.User;

import java.math.BigDecimal;
import java.util.ArrayList;

import static homeworks.HW_9_multithreading.logic.OperationsThread.*;

public class ATMApplication {

    public void run() {
        initialize();
        final OperationsThread thread1 = new OperationsThread();
        final OperationsThread thread2 = new OperationsThread();
        final OperationsThread thread3 = new OperationsThread();

        thread1.start();
        thread2.start();
        thread3.start();
    }


    private void initialize() {
        users = new ArrayList<>();
        users.add(new User(BigDecimal.valueOf(24500.00), BigDecimal.valueOf(20000.00), "Stepan", "Razin"));
        users.add(new User(BigDecimal.valueOf(12740.00), BigDecimal.valueOf(2000.00), "Petr", "Kosovoi"));
        users.add(new User(BigDecimal.valueOf(2745.34), BigDecimal.valueOf(2000.00), "Matrena", "Ivanova"));
        users.add(new User(BigDecimal.valueOf(5262.55), BigDecimal.valueOf(2000.00), "Oleg", "Shinvali"));
        users.add(new User(BigDecimal.valueOf(315.16), BigDecimal.valueOf(2000.00), "Diana", "Terezova"));

        atms = new ArrayList<>();
        atms.add(new ATM(BigDecimal.valueOf(0.00), "Prospect Prosveshenia 12a"));
        atms.add(new ATM(BigDecimal.valueOf(0.00), "Ulitsa Dobrolubova 44"));
        atms.add(new ATM(BigDecimal.valueOf(0.00), "Krasnii Prospect 8"));
    }

}
