package homeworks.HW_9_multithreading.logic;

import lombok.SneakyThrows;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class Util {

    public static String format(BigDecimal amount) {
        return NumberFormat.getCurrencyInstance(Locale.US).format(amount);
    }

    public static String getDepositOrWithdraw() {
        return new Random().nextInt() > 0 ? "withdraw" : "deposit";
    }

    public static <T> T getRandom(ArrayList<T> arrayList) {
        int n = (int) (Math.random() * arrayList.size());
        return arrayList.get(n);
    }

    public static BigDecimal getRandomBigDecimal(double min, double max) {
        double diff = max - min;
        int diffInt = (int) (diff * 100);
        int i = new Random().nextInt(diffInt + 100);
        i += min * 100;
        double result = (double) i / 100;
        return BigDecimal.valueOf(result);
    }

}
