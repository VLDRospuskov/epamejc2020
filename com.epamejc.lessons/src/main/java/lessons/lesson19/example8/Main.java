package lessons.lesson19.example8;

public class Main {

    public static void main(String[] args) {
        final MyThread myThread = new MyThread();
        myThread.stop();
        myThread.resume();
        myThread.suspend();
    }
}


class MyThread extends Thread {

}