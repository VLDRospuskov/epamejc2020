package lessons.lesson18.example8;

public class Main {
    
    public static void main(String[] args) {
        final Thread walk = new Thread(new Walk());
        final Talk talk = new Talk();
        talk.setDaemon(true);
        
        walk.start();
        talk.start();
    }
    
}

class Walk implements Runnable {
    
    public void run() {
        for (int i = 0; i < 8; i++) {
            System.out.println("Walking");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
    }
    
}

class Talk extends Thread {
    
    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                System.out.println("Talking");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.err.print(e);
                }
            }
        } finally {
            System.out.println("TALK FINNALY BLOCK");
        }
    }
    
}