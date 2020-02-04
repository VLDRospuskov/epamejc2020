package main.lessons.lesson10.example4;

// write slack
public class Main {

    public static void main(String[] args) {
        method();
    }

    public static void method() {
        throw getRuntimeException();
    }

    public static RuntimeException getRuntimeException() {
        return new RuntimeException();
    }

}
