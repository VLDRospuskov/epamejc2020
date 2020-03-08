package lessons.java.lesson20.example10;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
//    final Phaser phaser = new Phaser();
//    final Exchanger<Object> objectExchanger = new Exchanger<Object>();
//    final CountDownLatch countDownLatch = new CountDownLatch();
//    final CyclicBarrier cyclicBarrier = new CyclicBarrier();
        final Semaphore semaphore = new Semaphore(2);
        final Cat barsik = new Cat("Barsik");
        final Cat murzik = new Cat("Murzik");
        final Cat kitty = new Cat("Kitty");
        final Cat rijik = new Cat("Rijik");
        final Cat bagira = new Cat("Bagira");

        new MySemaphoreThread(barsik, semaphore).start();
        new MySemaphoreThread(murzik, semaphore).start();
        new MySemaphoreThread(kitty, semaphore).start();
        new MySemaphoreThread(rijik, semaphore).start();
        new MySemaphoreThread(bagira, semaphore).start();
    }

}

class MySemaphoreThread extends Thread {


    private final Semaphore semaphore;

    public MySemaphoreThread(Cat cat, Semaphore semaphore) {
        super(cat.getName());
        this.semaphore = semaphore;
    }

    @Override
    @SneakyThrows
    public void run() {
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + " ready to get dish");
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + " is eating");
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + " ready to leave");
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + " left");
        semaphore.release();
    }
}

@Data
@AllArgsConstructor
class Cat {

    private String name;

}