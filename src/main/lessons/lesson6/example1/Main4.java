package main.lessons.lesson6.example1;

public class Main4 {

    public static void main(String[] args) {
        Cat cat1 = new Cat(1, "Barsik");
        Cat cat2 = new Cat(2, "Barsik");
        Cat cat3 = new Cat(3, "Barsik");
        myMethod(cat1, cat2, cat3);
    }

    // myMethod(Cat cat1, Cat cat2,
    public static void myMethod(Cat... cats) {

    }

}
