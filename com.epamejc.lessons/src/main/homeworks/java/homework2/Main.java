package main.homeworks.java.homework2;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Jack", 33, "+185743523");
        System.out.println(p1);
        p1 = p1.changeNumber("+139845344");
        System.out.println(p1);
    }
}
