package lessons.lesson18.example2;

public class Main {

    public static void main(String[] args) {
        Thread thread = new MyThread();
        thread.start();

        MyRunnable myRunnable = new MyRunnable();
        Thread thread2 = new Thread(myRunnable);
        thread2.start();
    }

}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("MyRunnable");
    }
}

class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("MyThread");
    }
}