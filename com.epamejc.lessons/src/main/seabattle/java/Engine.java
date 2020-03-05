package seabattle.java;

import java.util.ArrayList;

import static seabattle.java.Utils.*;


public class Engine {

    Field field1;
    Field field2;

    public Engine() {
        field1 = new Field();
        field2 = new Field();
        field1.printField();
    }

    public void startWithManualShipPlacement () {
        manualShipPlacement(field1);
        field1.printField();
        manualShipPlacement(field1);
        field1.printField();
        manualShipPlacement(field1);
        field1.printField();
        manualShipPlacement(field1);
        field1.printField();
        System.out.println("Ships size: " + field1.getShips().size());


    }

    public Field manualShipPlacement (Field field) {
        ArrayList params = scanShipParams(field);
        Integer shipType = (Integer) params.get(0);
        if (shipType == 2) {
            field = twoCellsShipPlace(field, params);
        }

        return field;
    }

    public Field twoCellsShipPlace(Field field, ArrayList params) {
        Integer shipType = (Integer) params.get(0);
        Integer[] startYX = (Integer[]) params.get(1);
        Integer[] endYX = (Integer[]) params.get(2);

        field.getShips().add(new Ship(shipType, startYX, endYX, field));
        boolean shipInitOk = field.getShips().get(field.getShips().size() - 1).isInitOk();
        if (!shipInitOk) {
            field.getShips().remove(field.getShips().size() - 1);
        }
        return field;
    }

}
