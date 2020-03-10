package homeworks.HW_9_multithreading;

import java.math.BigDecimal;
import java.util.ArrayList;

import static homeworks.HW_9_multithreading.ATMOperations.*;
import static homeworks.HW_9_multithreading.BankAccount.bankAccount;

public class ATMApplication {

    public void run() {
        initialize();
        final ATMOperations thread1 = new ATMOperations();
        final ATMOperations thread2 = new ATMOperations();
        final ATMOperations thread3 = new ATMOperations();
        final ATMOperations thread4 = new ATMOperations();
        final ATMOperations thread5 = new ATMOperations();

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }


    private void initialize() {
        users = new ArrayList<>();
        users.add(new User(BigDecimal.valueOf(24500.00), BigDecimal.valueOf(20000.00), "Stepan", "Razin"));
        users.add(new User(BigDecimal.valueOf(12740.00), BigDecimal.valueOf(2000.00), "Petr", "Kosovoi"));
        users.add(new User(BigDecimal.valueOf(2745.34), BigDecimal.valueOf(2000.00), "Matrena", "Ivanova"));
        users.add(new User(BigDecimal.valueOf(5262.55), BigDecimal.valueOf(2000.00), "Oleg", "Shinvali"));
        users.add(new User(BigDecimal.valueOf(315.16), BigDecimal.valueOf(2000.00), "Diana", "Terezova"));

        atms = new ArrayList<>();
        atms.add(new ATM(BigDecimal.valueOf(15000.00), "Prospect Prosveshenia 12a"));
        atms.add(new ATM(BigDecimal.valueOf(15000.00), "Ulitsa Dobrolubova 44"));
        atms.add(new ATM(BigDecimal.valueOf(15000.00), "Krasnii Prospect 8"));
    }

}
