package lessons.java.lesson18.example7;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Talk talk = new Talk();
        talk.start();


        System.out.println(talk.isInterrupted());
        talk.interrupt();

        Thread.sleep(1000);
        System.out.println(talk.isInterrupted()); // slack


    }

}


class Talk extends Thread {

    int number = 0;

    public void run() {
        while (!Thread.interrupted()) {
            number++; // sleep
        }
    }
}