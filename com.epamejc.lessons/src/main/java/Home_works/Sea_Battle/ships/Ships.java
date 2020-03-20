package Home_works.Sea_Battle.ships;

import Home_works.Sea_Battle.field.FieldCreator;
import Home_works.Sea_Battle.field.PlantField;

import java.util.*;

public class Ships {
    public FieldCreator createShips(FieldCreator battleFieldCreator, CoordinatesList coordinatesList) {
        Queue<Integer> queueShip = new LinkedList<>(Arrays.asList(4, 3, 3, 2, 2, 2, 1, 1, 1, 1));
        ShipCreator shipCreator = new ShipCreator();
        PlantField plantFieald = new PlantField();

        int deckCount;
        while (queueShip.peek() != null) {
            deckCount = queueShip.peek();
            if (shipCreator.setShip(coordinatesList, deckCount)) {
                queueShip.remove();
            }
        }
        plantFieald.getPlant(battleFieldCreator.getField(), coordinatesList);
        shipCreator.setShip(coordinatesList, 4);
        return battleFieldCreator;
    }
}
