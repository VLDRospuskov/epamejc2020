package lessons.lesson1.modifier_access.model2;

import lessons.lesson1.modifier_access.model.Human;

public class Man extends Human {
    
    private void callWomanMethodsFromHuman() {
        /**
         * public - доступен везде
         * protected - класс Man является наследником Human* или лежит в одном же пакете
         * package - вызвать нельзя так как класс не лежит в одном же пакете с классом Human
         * private - вызывать нелья так как private работает только на уровне класса
         */
        publicMove();
        protectedMove();
//        packageMove();
//        privateMove();
    }
    
}
