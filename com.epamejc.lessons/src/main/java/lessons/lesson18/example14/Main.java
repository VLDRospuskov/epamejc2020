package lessons.java.lesson18.example14;

public class Main {

    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(
                new Thread.UncaughtExceptionHandler() {
                    public void uncaughtException(Thread t, Throwable e) {
                        System.out.println(t + " (default handler)throws exception: " + e);
                    }
                });
        Thread t1 = new Thread(new MyThread());
        Thread t2 = new Thread(new MyThread());
        t2.setUncaughtExceptionHandler(
                new Thread.UncaughtExceptionHandler() {
                    public void uncaughtException(Thread t, Throwable e) {
                        System.out.println(t + " throws exception: " + e);
                    }
                });
        t1.start();
        t2.start();

    }
}

class MyThread implements Runnable {
    public void run() {
        throw new RuntimeException("It is a greate exception.");
    }
}