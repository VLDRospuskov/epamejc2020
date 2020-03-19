package homeworks.java.multithreading;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

@AllArgsConstructor
public class CollectorOperations extends Thread {

    Collector collector;

    @SneakyThrows
    @Override
    public void run() {

        while (true) {
            Thread.sleep(2000L);
            for (ATM atm : collector.getAtms()) {
                if (atm.isOnService()) {
                    collector.service(atm);
                }
            }
        }

    }

}