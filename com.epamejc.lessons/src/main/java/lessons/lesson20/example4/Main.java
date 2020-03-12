package lessons.lesson20.example4;

import java.util.concurrent.ArrayBlockingQueue;

public class Main {

    // case
    public static void main(String[] args) {
        Resource.integers.add(1);
        Resource.integers.add(2);
        Resource.integers.add(3);
        Resource.integers.add(4);
        Resource.integers.add(5);
        Resource.integers.add(6);
        Resource.integers.add(7);
        Resource.integers.add(8);
        Resource.integers.add(9);
        Resource.integers.add(10);

        new DeleteThread().start();
        new DeleteThread().start();
        new DeleteThread().start();
        new DeleteThread().start();
        new DeleteThread().start();
        new DeleteThread().start();
        new DeleteThread().start();
        new DeleteThread().start();
    }
}

class Resource {
    static ArrayBlockingQueue<Integer> integers = new ArrayBlockingQueue<>(10);
    static int size = 10;
}

class DeleteThread extends Thread {

    @Override
    public void run() {
        while (--Resource.size > 0) {
            Resource.integers.remove();
        }
    }

}
