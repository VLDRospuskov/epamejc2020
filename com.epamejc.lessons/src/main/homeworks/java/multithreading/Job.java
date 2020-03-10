package homeworks.java.multithreading;

public class Job{

    public static void doJob() {

        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
