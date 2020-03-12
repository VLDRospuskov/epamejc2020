package lessons.lesson20.example9;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        new Thread(new MyThread()).start();
        new Thread(new MyThread()).start();
        new Thread(new MyThread()).start();
        Thread.sleep(2000);
        System.out.println("Sum: " + MyThread.count);

        new AtomicThread().start();
        new AtomicThread().start();
        new AtomicThread().start();
        Thread.sleep(2000);
        System.out.println("Sum atomic: " + AtomicThread.count);
    }

}

class MyThread implements Runnable {
    public static volatile int count;
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            count++;
        }
        System.out.println(count);
    }
}

class AtomicThread extends Thread {
    public static AtomicInteger count = new AtomicInteger(0);
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            count.getAndAdd(1);
        }
        System.out.println(count);
    }
}
