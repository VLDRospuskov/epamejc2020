package lessons.lesson19.example4;

public class Main {

    public static void main(String[] args) {
        final ThreadWrite threadWrite = new ThreadWrite();
        final ThreadRead threadRead = new ThreadRead();

        threadWrite.start();
        threadRead.start();
    }

}

class Resource {

    public volatile static boolean isExit = false;

}

class ThreadRead extends Thread {

    @Override
    public void run() {
        boolean localIsExit = false;
        while (!localIsExit) {

            if (Resource.isExit) {
                localIsExit = true;
            }
        }
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("THREAD READ STOPPED");
    }
}

class ThreadWrite extends Thread {

    private int count = 0;

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Increment count: " + ++count);
        }
        System.out.println("Sum count = " + count);
        Resource.isExit = true;
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("NOW isExit " + Resource.isExit);
    }

}