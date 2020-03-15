package homeworks;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
    public static Integer value = 0;

    public static void main(String[] args) {
        BigDecimal qwe = new BigDecimal(123.456789);
        System.out.println(qwe);

        System.out.println(qwe.setScale(5, RoundingMode.UP));
    }

}