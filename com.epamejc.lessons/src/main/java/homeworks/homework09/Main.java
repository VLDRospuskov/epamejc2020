package homeworks.homework09;

import lombok.SneakyThrows;

import java.math.BigDecimal;

public class Main {
    public static int valueInt = 0;
    public static BigDecimal valueBD = BigDecimal.ZERO;

    @SneakyThrows
    public static void main(String[] args) {

        UserThread userThread1 = new UserThread(new User("Masha"));
        UserThread userThread2 = new UserThread(new User("Sasha"));
        UserThread userThread3 = new UserThread(new User("Pasha"));
        UserThread userThread4 = new UserThread(new User("Dasha"));
        UserThread userThread5 = new UserThread(new User("Gosha"));

        userThread1.start();
        userThread2.start();
        userThread3.start();
        userThread4.start();
        userThread5.start();

    }

}