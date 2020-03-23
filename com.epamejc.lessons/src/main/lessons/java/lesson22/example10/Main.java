package lessons.java.lesson22.example10;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    static int number = 0;

    public static synchronized void increment() {
        for (int i = 0; i < 1_000_000; i++) {
            number++;
        }
    }

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService =
                Executors.newScheduledThreadPool(4);

        scheduledExecutorService.execute(() -> increment());
        scheduledExecutorService.execute(() -> increment());

        scheduledExecutorService.shutdown();
        try {
            scheduledExecutorService.awaitTermination(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(number);
    }
}
