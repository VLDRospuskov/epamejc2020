package seabattle;

import seabattle.Enums.Direction;
import seabattle.Enums.ShipPlacingStrategy;

import java.util.LinkedList;
import java.util.List;
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
        int numberOfDecks = Settings.maximumNumberOfShipDecks;

        int row = new Random().nextInt(Settings.fieldRows);
        int column = new Random().nextInt(Settings.fieldColumns);
        Direction randomDirection = Direction.getRandomDirection();
        ShipPlacingParams shipPlacingParams = new ShipPlacingParams(row,column,numberOfDecks, randomDirection);
        for (int decks = 0; decks < numberOfDecks; decks++) {
            for (int ships = 0; ships < numberOfShips; ships++) {
                shipPlacingParams
            }
        }

        player.getShipsCounter().shipMap.forEach((decks, numberOfShips) -> {
            for (int i = 0; i < numberOfShips; i++) {
                FieldDrawer.printMenu(player.getMainField());
                ShipPlacingParams shipPlacingParams;
                do {
                    String shipPlacement = readShipPlacement(decks);
                    shipPlacingParams = new ShipPlacingParams(shipPlacement, decks);
                    System.out.println(player.getMainField().isShipPlacementLegal(shipPlacingParams) ?
                            "Ship placed successfully" :
                            "Ship can't be placed here");
                } while (!player.getMainField().isShipPlacementLegal(shipPlacingParams));
                player.getMainField().placeShip(shipPlacingParams);
            }
        });

        return field;
    }

}
