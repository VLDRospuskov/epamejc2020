package lessons.lesson18.example4;

import java.util.concurrent.TimeUnit;

public class Main {
    
    public static void main(String[] args) throws InterruptedException {
        final Thread walk = new Thread(new Walk());
        System.out.println(walk.getState()); // NEW
        final Talk talk = new Talk();
        
        // MAIN.THREAD
        talk.start(); // MAIN.THREAD talk.THREAD
        walk.start(); // MAIN.THREAD talk.THREAD walk.THREAD
        System.out.println(walk.getState()); // RUNNABLE / TIMED_WAITING
        Thread.sleep(900); //MAIN THREAD
        System.out.println(walk.getState()); // RUNNABLE / TIMED_WAITING
        
        TimeUnit.SECONDS.sleep(7);
        System.out.println(walk.getState()); // TERMINATED
        
    }
    
}

class Walk implements Runnable {
    
    public void run() {
        for (int i = 0; i < 8; i++) {
            System.out.println("Walking");
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
    }
    
}

class Talk extends Thread {
    
    public void run() {
        for (int i = 0; i < 8; i++) {
            System.out.println("Talking");
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                System.err.print(e);
            }
        }
    }
    
}

