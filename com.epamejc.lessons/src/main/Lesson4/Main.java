package main.Lesson4;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Alex", "m");
        System.out.println(p1);

        Person p2 = new Person("Anna", "f");
        System.out.println(p2);
        System.out.println(p2.hashCode());
        p2.setName("Dima");
        p2.setSex("m");
        System.out.println(p2);
        System.out.println(p2.hashCode());
    }
}
