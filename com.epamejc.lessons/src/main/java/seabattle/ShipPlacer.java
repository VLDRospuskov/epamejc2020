package seabattle;

import seabattle.Enums.Direction;
import seabattle.Enums.ShipPlacingStrategy;

import java.util.Random;

public class ShipPlacer {

    public static Field getFieldWithShipsPlacedByStrategy(ShipPlacingStrategy shipPlacingStrategy) {
        switch (shipPlacingStrategy) {
            case RANDOM:
                return placeShipsRandomly();
            default:
                break;
        }
        return placeShipsRandomly();
    }

    public static Field placeShipsRandomly() {
        Field field = new Field(Settings.fieldRows, Settings.fieldColumns);
        int numberOfShips = 1;

        ShipPlacingParams shipPlacingParams;

        for (int decks = Settings.maximumNumberOfShipDecks; decks > 0; decks--) {
            for (int ships = 0; ships < numberOfShips; ships++) {
                do {
                    int row = new Random().nextInt(Settings.fieldRows);
                    int column = new Random().nextInt(Settings.fieldColumns);
                    Direction randomDirection = Direction.getRandomDirection();
                    shipPlacingParams = new ShipPlacingParams(row, column, decks, randomDirection);
                    shipPlacingParams.setNumberOfDecks(decks);
                } while (!field.isShipPlacementLegal(shipPlacingParams));
                field.placeShip(shipPlacingParams);
            }
            numberOfShips++;
        }

        return field;
    }

}
