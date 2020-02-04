package main.lessons.lesson6.example1;

public class Main1 {

    public static void main(String[] args) throws CloneNotSupportedException {
        Cat cat = new Cat(1, "Barsik");
        Object clone = cat.clone();
        System.out.println(cat);
        System.out.println(clone);
    }
}
