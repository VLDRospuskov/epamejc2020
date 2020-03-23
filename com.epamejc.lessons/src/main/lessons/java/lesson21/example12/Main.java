package lessons.java.lesson21.example12;

public class Main {

    public static void main(String[] args) {
        Cat cat = new Cat();
        System.out.println(null instanceof Cat); // false
        System.out.println(cat instanceof Animal); // true
        System.out.println(cat instanceof Cat); // true
    }

}

interface Animal {}
class Cat implements Animal {}
