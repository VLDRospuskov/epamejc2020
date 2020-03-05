package lessons.java.lesson19.example1;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        /** static value = 0;
         * Thread1 1
         * Thread2 1
         *  1
         * value++;
         */
        final MyThread myThread = new MyThread();
        final MyThread myThread2 = new MyThread();
        myThread.start();
        myThread2.start();

//        try {
//            myThread.join();
//            myThread2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        while (myThread.isAlive() || myThread2.isAlive()) {
            System.out.println(myThread.getState());
            System.out.println(myThread2.getState());
        }

        TimeUnit.SECONDS.sleep(10);
        System.out.println(Resource.value);
    }

}

class MyThread extends Thread {

    static Object lock = new Object();

    @Override
    public void run() {
        for (int i = 0; i < 1_000_000; i++) {  // 2 //3
            synchronized (Resource.class) { // 1 - MONITORENTER // 1 // 2
                Resource.value++;
            } // 1 - MONITOREXIT // 1 // 2
        }
    }
}

class Resource {

    public static int value = 0;

    public synchronized static void increment() {
        value++;
    }

}
