package com.epamejc.lessons.src.homework.homework2.immutable.task1;

public class Main {
    public static void main(String[] args) {
        new Main().start();
    }

    public void start() {
        Dog dog = new Dog("Tofu", 2, "Shiba Inu");
        System.out.println("Dog №1");
        System.out.println(dog.toString());
        Dog dog2 = new Dog("Sharik", 3, "Pug");
        System.out.println("Dog №2");
        System.out.println(dog2.toString());
    }
}
