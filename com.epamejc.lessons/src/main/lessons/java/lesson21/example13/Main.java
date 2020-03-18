package lessons.java.lesson21.example13;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
//         Future result = executorService(System.out::println);
//         executorService.invokeAll(null);
//         executorService.sc(() -> {return;}, 100, TimeUnit.SECONDS);
    }

}
