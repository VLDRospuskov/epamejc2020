package lessons.java.lesson18.example11;

public class Main implements Runnable {

    public void run() {
        Thread.State state = Thread.currentThread().getState();
        System.out.println(Thread.currentThread().getName() + " " + state);
    }

    public static void main(String args[]) {
        Thread th1 = new Thread(new Main());
        th1.start();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println(e);
        }
        Thread.State state = th1.getState();
        System.out.println(th1.getName() + " " + state);
    }

}
