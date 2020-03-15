package homeworks.homework09;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ATM_System {

    final static int ATM_NUMBER = 3;
    final static List<ATM> atmList = new ArrayList<>();

    static {
        for (int i = 0; i < ATM_NUMBER; i++) {
            atmList.add(new ATM(i + 1));
        }
    }

    public static BigDecimal getAllAtmBalance() {
        BigDecimal result = BigDecimal.ZERO;
        for (int i = 0; i < ATM_NUMBER; i++) {
            result = result.add(atmList.get(i).atmBalance);
        }
        return result;
    }

}
