package lessons.lesson20.example3;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    
    public static void main(String[] args) throws InterruptedException {
        final MyThread myThread = new MyThread();
        final MyThread myThread2 = new MyThread();
        final MyThread myThread3 = new MyThread();
        
        myThread.start();
        myThread2.start();
        myThread3.start();
        
        myThread.join();
        myThread2.join();
        myThread3.join();
        
        System.out.println(Resource.atomicInteger.get());
    }
    
}

class Resource {
    
    public static AtomicInteger atomicInteger = new AtomicInteger(0);
//    public static ArrayBlockingQueue<Integer> homework4 = new ArrayBlockingQueue<>(100000);

}

class MyThread extends Thread {
    
    @Override
    public void run() {
        for (int i = 0; i < 1_000_000; i++) {
            Resource.atomicInteger.getAndIncrement();
        }
    }
    
}
