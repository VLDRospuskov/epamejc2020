package lessons.java.lesson14.example6;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        HashSet<Cat> setCats = new HashSet<>();
        Cat cat = new Cat(10);
        Cat cat2 = new Cat(20);
        setCats.add(cat);
        setCats.add(cat2);
    }
}
