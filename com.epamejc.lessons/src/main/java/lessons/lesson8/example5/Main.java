package lessons.lesson8.example5;

import java.util.Date;

public class Main {
    
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
    
            @Override
            public void run() {
        
            }
        };
        
        Runnable runnable2 = () -> System.out.println("Runnable");
        Thread thread = new Thread(runnable2);
        thread.start();
        
        MyThread myThread = new MyThread();
        myThread.start();
        
        MyRunnable myRunnable = new MyRunnable();
        
        Date date = new Date() {
            
            @Override
            public int hashCode() {
                return super.hashCode();
            }
            
            @Override
            public String toString() {
                return "heloo date";
            }
        };
        
        System.out.println(date.toString());
    }
    
}

class MyRunnable implements Runnable {
    
    @Override
    public void run() {
    
    }
    
}

class MyThread extends Thread {
    
    @Override
    public void run() {
        super.run();
    }
    
}