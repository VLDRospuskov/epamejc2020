package lessons.lesson20.example8;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Resource {
    
    public static int number = 0;
    public static Lock lock = new ReentrantLock();
    
}

public class Main implements Runnable {
    
    public static void main(String[] args) throws InterruptedException {
        Main lock1 = new Main();
        Main lock2 = new Main();
        Thread th1 = new Thread(lock1);
        Thread th2 = new Thread(lock2);
        
        th1.start();
        th2.start();
        
        Thread.sleep(2000);
        System.out.println(Resource.number);
    }
    
    public void run() {
        for (int i = 0; i < 1000000; i++) {
//                if (lock.tryLock()){
//
//                }else{
//                }
//                count++;
//                System.out.println(Thread.currentThread().getName());
//                lock.unlock();
            Resource.lock.lock();
            Resource.number++;
            run2();
        }
    }
    
    public void run2() {
        Resource.lock.unlock();
    }
    
}
