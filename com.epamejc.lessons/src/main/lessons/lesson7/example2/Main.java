package main.lessons.lesson7.example2;

public class Main {

    public static void main(String[] args) {
        Message<String, String> stringStringMessage = new Message<>("String", "String");
        Message<Integer, String> hello = new Message<>(1, "hello");
        Message<Integer, Integer> integerIntegerMessage = new Message<>(10, 55);
    }
}
