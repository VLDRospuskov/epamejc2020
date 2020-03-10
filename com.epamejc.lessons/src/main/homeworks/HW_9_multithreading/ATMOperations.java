package homeworks.HW_9_multithreading;

import lombok.SneakyThrows;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class ATMOperations extends Thread {

    public static ArrayList<User> users;
    public static ArrayList<ATM> atms;

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName());
            if (getRandomBoolean()) {
                withdraw(getRandom(users), getRandom(atms), getRandomBigDecimal(100.00, 2000.00));
            } else {
                put(getRandom(users), getRandom(atms), getRandomBigDecimal(100.00, 2000.00));
            }
            Thread.sleep((int) (Math.random() * 1000));
        }
    }

    private BigDecimal getRandomBigDecimal(double min, double max) {
        double diff = max - min;
        int diffInt = (int) (diff * 100);
        int i = new Random().nextInt(diffInt + 100);
        i += min * 100;
        double result = (double) i / 100;
        return BigDecimal.valueOf(result);
    }

    private <T> T getRandom(ArrayList<T> arrayList) {
        int n = (int) (Math.random() * arrayList.size());
        return arrayList.get(n);
    }

    private Boolean getRandomBoolean() {
        return new Random().nextInt() > 0;
    }

    public static String format(BigDecimal amount) {
        return NumberFormat.getCurrencyInstance(Locale.US).format(amount);
    }

    public static void withdraw (User user, ATM atm, BigDecimal amount) {
        if (user.getCash(amount)) {
            atm.withdraw(amount);
        }
        System.out.println("----------------------");
    }

    public static void put (User user, ATM atm, BigDecimal amount) {
        if (user.putCash(amount)) {
            atm.deposit(amount);
        }
        System.out.println("----------------------");
    }

}
