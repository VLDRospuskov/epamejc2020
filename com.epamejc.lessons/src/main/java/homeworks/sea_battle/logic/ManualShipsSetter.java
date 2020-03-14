package homeworks.sea_battle.logic;

import homeworks.sea_battle.commands.ShipsSetterCommands;
import homeworks.sea_battle.data.Coordinates;
import homeworks.sea_battle.data.Field;
import homeworks.sea_battle.data.Ship;
import homeworks.sea_battle.enums.ShipTypes;
import homeworks.sea_battle.enums.SystemMessages;
import lombok.AllArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
public class ManualShipsSetter implements ShipsSetterCommands {

    private IOOperations ioOperations;

    @Override
    public ArrayList<Ship> createShips(Field field, ShipTypes shipType, int shipQty) {
        ArrayList<Ship> ships = new ArrayList<>();

        for (int i = 0; i < shipQty; i++) {
            while (true) {
                PrintFieldCommand.printField(field.getField());
                System.out.println("Set " + shipType.toString());
                System.out.print(SystemMessages.SET_COORDS.message);

                Coordinates coordinates = ioOperations.parseCoordinates();
                boolean direction;
                if (shipType.getValue() == 1) {
                    direction = true;
                } else {
                    direction = ioOperations.parseDirection(coordinates, shipType.getValue());
                }

                ArrayList<Coordinates> decks = createDecks(shipType.getValue(), direction, coordinates.getX(), coordinates.getY());

                if (checkRange(field.getField(), decks)) {
                    Ship ship = new Ship(shipType, decks);
                    ships.add(ship);
                    setShipOnField(field.getField(), ship);
                    break;
                }
            }
        }

        return ships;
    }

}
