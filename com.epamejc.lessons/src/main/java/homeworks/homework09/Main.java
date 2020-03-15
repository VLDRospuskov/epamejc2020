package homeworks.homework09;

import lombok.SneakyThrows;

import java.math.BigDecimal;



/**
 * To make app run without sleeping, comment line #24 in {@link User#executeOperation}
 * To make output ordinary, switch {@link Main#ATM_PRINT_IN_COLUMNS} to false
 * To make app run infinitely, change condition in {@link UserThread#run()} to while(true)
 */
public class Main {
    public final static boolean ATM_PRINT_IN_COLUMNS = true;
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