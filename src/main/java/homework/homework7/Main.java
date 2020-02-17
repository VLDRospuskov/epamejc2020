package homework.homework7;

import homework.homework7.battlefield.Field;
import homework.homework7.battlefield.FieldInitiator;
import lombok.SneakyThrows;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {

        FieldInitiator initiator = new FieldInitiator();
        initiator.init();
    }
}
