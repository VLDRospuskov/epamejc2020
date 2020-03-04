package lessons.java.lesson20.example7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    // shutDown
    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        final ExecutorService executorService = Executors.newCachedThreadPool();
//        List<Callable<Object>> callables = new ArrayList<>();
//        callables.add(Executors.callable(new MyThread()));
//        callables.add(Executors.callable(new MyThread()));
//        callables.add(Executors.callable(new MyThread()));
//        callables.add(Executors.callable(new MyThread()));
//        callables.add(Executors.callable(new MyThread()));
//        callables.add(Executors.callable(new MyThread()));
//        callables.add(Executors.callable(new MyThread()));
//        callables.add(Executors.callable(new MyThread()));
//        callables.add(Executors.callable(new MyThread()));
//        executorService.invokeAll(callables);
//        System.out.println(callables.size());

        ExecutorService executorService2 = Executors.newCachedThreadPool();
        List<Callable<Integer>> callables2 = new ArrayList<>();
        callables2.add(new MyCallable(1));
        callables2.add(new MyCallable(2));
        callables2.add(new MyCallable(3));
        callables2.add(new MyCallable(4));
        callables2.add(new MyCallable(5));
        callables2.add(new MyCallable(6));
        final List<Future<Integer>> futures = executorService2.invokeAll(callables2);
        final Integer integer = executorService2.invokeAny(callables2);
        System.out.println(integer);

        final Integer collect = futures.stream().map(v -> {
            try {
                return v.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            return null;
        }).mapToInt(Integer::intValue).sum();
        System.out.println(collect);


    }

}

class MyCallable implements Callable {

    private Integer integer;

    public MyCallable(Integer integer) {
        this.integer = integer;
    }

    @Override
    public Integer call() {
        return integer;
    }
}

class MyThread extends Thread {

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getId() + " my thread is running");
    }

}