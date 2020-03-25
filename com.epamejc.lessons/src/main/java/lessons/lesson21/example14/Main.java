package lessons.java.lesson21.example14;

import java.util.concurrent.Callable;

public class Main {

    public static void main(String[] args) {
        // new MyCallable().start();
    }

}

class MyCallable implements Callable {
    @Override
    public Object call() throws Exception {
        return null;
    }
}
/**
 *
 * class MyCallable implements Callable {
 *
 *     public void run() {
 *
 *     }
 * }
 * */