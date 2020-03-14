package homeworks.sea_battle.logic;

import homeworks.sea_battle.commands.ShipsSetterCommands;
import homeworks.sea_battle.data.Coordinates;
import homeworks.sea_battle.data.Field;
import homeworks.sea_battle.data.Ship;
import homeworks.sea_battle.enums.ShipTypes;
import homeworks.sea_battle.utils.RandomGenerator;

import java.util.ArrayList;

public class AutomaticShipSetter implements ShipsSetterCommands {
    @Override
    public ArrayList<Ship> createShips(Field field, ShipTypes shipType, int shipQty) {
        ArrayList<Ship> ships = new ArrayList<>();
        ArrayList<Coordinates> decks;

        for (int i = 0; i < shipQty; i++) {
            while (true) {
                Coordinates coord = RandomGenerator.generateCoordinates();
                boolean direction = RandomGenerator.generateDirection();

                if ((coord.getX() + shipType.getValue()) > (field.getSIZE()) - 1 && direction) {
                    continue;
                } else if ((coord.getY() + shipType.getValue()) > (field.getSIZE()) - 1 && !direction) {
                    continue;
                }

                decks = createDecks(shipType.getValue(), direction, coord.getX(), coord.getY());

                if (checkRange(field.getField(), decks)) {
                    Ship ship = new Ship(shipType, decks);
                    ships.add(ship);
                    setShipOnField(field.getField(), ship);
                    break;
                } else {
                    decks.clear();
                }
            }
        }
        return ships;
    }
}
