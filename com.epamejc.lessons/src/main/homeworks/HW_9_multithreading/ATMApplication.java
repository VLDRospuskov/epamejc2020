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

        thread1.start();
        thread2.start();


//        int i = 5;
//        while (i > 0) {
//            withdraw(users.get(0), atms.get(0), BigDecimal.valueOf(5000.00));
////            put(users.get(0), atms.get(0), BigDecimal.valueOf(5000.00));
//            i--;
//            System.out.println("Money in the bank: " + format(bankAccount));
//            System.out.println("-------------------------------------------");
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
