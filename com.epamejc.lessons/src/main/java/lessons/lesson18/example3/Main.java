package lessons.lesson18.example3;

public class Main {
    
    public static void main(String[] args) {
        Thread main = Thread.currentThread();
        System.out.println(main.getId());
        System.out.println(main.getName());
        System.out.println(main.getThreadGroup());
        main.setName("My SemDemo Thread");
        main.setPriority(Thread.MAX_PRIORITY);
        System.out.println(main);
        
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread thread = new MyThread();
        System.out.println(thread);
        System.out.println(thread.getId());
        thread.start();
        
        MyRunnable myRunnable = new MyRunnable();
        Thread thread2 = new Thread(myRunnable);
        System.out.println(thread2);
        System.out.println(thread2.getId());
        thread2.start();
    }
    
}

class MyRunnable implements Runnable {
    
    @Override
    public void run() {
//        System.out.println("MyRunnable");
    }
    
}

class MyThread extends Thread {
    
    @Override
    public void run() {
//        System.out.println("MyThread");
    }
    
}