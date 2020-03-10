package homeworks.HW_9_multithreading;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import static homeworks.HW_9_multithreading.ATMOperations.*;

public class ATMApplication {
    private ArrayList<User> users;
    private ArrayList<ATM> atms;

    public void run() {
        initialize();
        int i = 10;
        while (i > 0) {
            System.out.println("ATMBalance: " + format(atms.get(0).getBalance()));
            withdraw(users.get(0), atms.get(0), BigDecimal.valueOf(5000.00));
            put(users.get(0), atms.get(0), BigDecimal.valueOf(2000.00));
            System.out.println("ATMBalance: " + format(atms.get(0).getBalance()));
            i--;
            System.out.println("-------------------------------------------");
        }
    }







    private void initialize() {
        users = new ArrayList<>();
        users.add(new User(BigDecimal.valueOf(24500.00), BigDecimal.valueOf(2000.00), "Stepan", "Razin"));
        users.add(new User(BigDecimal.valueOf(12740.00), BigDecimal.valueOf(2000.00), "Petr", "Kosovoi"));
        users.add(new User(BigDecimal.valueOf(2745.34), BigDecimal.valueOf(2000.00), "Matrena", "Ivanova"));
        users.add(new User(BigDecimal.valueOf(5262.55), BigDecimal.valueOf(2000.00), "Oleg", "Shinvali"));
        users.add(new User(BigDecimal.valueOf(315.16), BigDecimal.valueOf(2000.00), "Diana", "Terezova"));

        atms = new ArrayList<>();
        atms.add(new ATM(BigDecimal.valueOf(15000.00), "Prospect Prosveshenia 12a"));
        atms.add(new ATM(BigDecimal.valueOf(15000.00), "Ulitsa Dobrolubova 44"));
        atms.add(new ATM(BigDecimal.valueOf(15000.00), "Krasnii Prospect 8"));
    }

//    BigDecimal modelVal = new BigDecimal("127455325472723762662662.4346365234")
//            .setScale(2, RoundingMode.HALF_EVEN);
//
//        System.out.println(modelVal);
//
//        System.out.println(NumberFormat.getCurrencyInstance(Locale.US).format(modelVal));

}
