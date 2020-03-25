package lessons.java.lesson21.example8;

import java.io.Closeable;

public class Main {

    public static void main(String[] args) {
        try (Animal animal = new Animal()) {
            System.out.println("hello");
        } finally {
            System.out.println("finally");
        }
        System.out.println("END");
    }

}

class Animal implements Closeable {

    @Override
    public void close() {

    }
}