package homework.seabattle;

import homework.seabattle.battlefield.FieldInitiator;
import lombok.SneakyThrows;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {

        FieldInitiator initiator = new FieldInitiator();
        initiator.init();
    }
}
