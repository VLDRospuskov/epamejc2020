package main.lessons.lesson1.modifier_access.model;

public class Woman extends Human {

    private void callWomanMethodsFromHuman() {
        /**
         * public - доступен везде
         * protected - класс Woman является наследником Human* или лежит в одном же пакете*
         * package - лежит в одном же пакете с классом Human
         * private - вызывать нелья так как private работает только на уровне класса
         */
        publicMove();
        protectedMove();
        packageMove();
//        privateMove();
    }

}
