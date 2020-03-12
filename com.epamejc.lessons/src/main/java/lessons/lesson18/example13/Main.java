package lessons.lesson18.example13;

public class Main {
    
    public static void main(String[] args) {
        Thread t = new Thread(new SimpleThread());
        t.setUncaughtExceptionHandler(
                new Thread.UncaughtExceptionHandler() {
    
                    public void uncaughtException(Thread t, Throwable e) {
                        System.out.println(t + " throws exception: " + e);
                    }
                });
        t.start();
    }
    
}

class SimpleThread implements Runnable {
    
    public void run() {
        throw new RuntimeException("It is a greate exception.");
    }
    
}
