package lessons.lesson20.example5;

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(new MyRunnable());
        final Future<Integer> submit = executorService.submit(new MyCallable());
        final Integer integer = submit.get();
        System.out.println(integer);
        executorService.shutdown();
    }

}

class MyCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return 10;
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getId() + " Hello my runnable");
    }
}