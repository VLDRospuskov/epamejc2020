package lessons.lesson20.example6;

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        final ScheduledFuture<Integer> schedule =
                scheduledExecutorService.schedule(new MyCallable(), 2, TimeUnit.SECONDS);
        try {
            System.out.println("Hello");
            final Integer integer = schedule.get();
            final Integer integer2 = schedule.get();
            final Integer integer3 = schedule.get();
            System.out.println(integer);
            System.out.println(integer2);
            System.out.println(integer3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        scheduledExecutorService.shutdown();
    }
}

class MyCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return 10;
    }
}