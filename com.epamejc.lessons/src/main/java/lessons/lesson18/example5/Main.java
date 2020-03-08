package lessons.java.lesson18.example5;

public class Main {

    public static void main(String[] args) {
        final Thread walk = new Thread(new Walk());
        final Talk talk = new Talk();
        final Talk talk2 = new Talk();
        final Talk talk3 = new Talk();
        final Talk talk4 = new Talk();
        final Talk talk5 = new Talk();
        final Talk talk6 = new Talk();
        final Talk talk7 = new Talk();
        final Talk talk8 = new Talk();

        talk.setName("OUR TALK THREAD");

        talk2.setPriority(Thread.MAX_PRIORITY);
        talk3.setPriority(Thread.MAX_PRIORITY);
        talk4.setPriority(Thread.MAX_PRIORITY);
        talk5.setPriority(Thread.MAX_PRIORITY);
        talk.setPriority(Thread.MIN_PRIORITY);
        talk6.setPriority(Thread.MAX_PRIORITY);
        talk7.setPriority(Thread.MAX_PRIORITY);
        talk8.setPriority(Thread.MAX_PRIORITY);

        System.out.println(talk.isAlive()); // false

        /**
         * NEW - false
         * RUNNABLE - true
         * WAITING - true
         * BLOCKED - true
         * TERMINATED - false
         */

        talk2.start();
        talk3.start();
        talk4.start();
        talk5.start();
        talk.start();
        System.out.println(talk.isAlive()); // true
        talk6.start();
        talk7.start();
        talk8.start();
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
        for (int i = 0; i < 8; i++) {
            System.out.println(Thread.currentThread() + " Talking");
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                System.err.print(e);
            }
        }
    }
}


