package main.lessons.lesson1.modifier_access;

import main.lessons.lesson1.modifier_access.model.Human;

public class Main {

    public static void main(String[] args) {

    }

    private void callMethods() {
        Human human = new Human();
        human.publicMove();
        /**
         * protected - нельзя так как класс Main не находится в пакете model, также не является наследником класса Human
         * package - нельзя так как класс Main не находится в пакете model
         * private - можно использовать только на уровне класса, то есть только в самом Human
         */
//        human.protectedMove();
//        human.packageMove();
//        human.privateMove();
    }
}
