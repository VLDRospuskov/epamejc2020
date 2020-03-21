package main.java.homework.immutable;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book(463, "Grokking Algorithm", "Aditya Y. Bhargava");
        Book book2 = new Book(764, "Thinking in Java", "Bruce Eckel");
        Book book3 = new Book(471, "Head first Java ", "Kathy Sierra");


        System.out.println(book1.getName());
        System.out.println(book1.getAuthor());
        System.out.println(book1.getPages());

        System.out.println(book2.getName());
        System.out.println(book2.getAuthor());
        System.out.println(book2.getPages());

        System.out.println(book3.getName());
        System.out.println(book3.getAuthor());
        System.out.println(book3.getPages());

    }
}
