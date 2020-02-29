package lessons.java.lesson18.example9;

public class Main {

    public static void main(String[] args) {
        final Walk walk = new Walk();
        final Talk talk = new Talk();

        walk.start();
        talk.start();
    }
}


class Walk extends Thread {
    public void run() {
        for (int i = 0; i < 100; i++) {
            Thread.yield();
            System.out.println("Walking");
        }
    }
}

class Talk extends Thread {
    public void run() {
        for (int i = 0; i < 100; i++) {
            Thread.yield();
            System.out.println("Talking");
        }
    }
}