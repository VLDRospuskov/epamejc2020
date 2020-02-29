package lessons.lesson18.example6;

public class Main {

    public static void main(String[] args) {
        final Thread walk = new Thread(new Walk());
        Talk talk = new Talk();

        walk.start();
        talk.start();

        try {
            walk.join();
            talk.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("I'm IN MAIN THREAD");
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
        for (int i = 0; i < 10; i++) {
            System.out.println("Talking");
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                System.err.print(e);
            }
        }
    }
}