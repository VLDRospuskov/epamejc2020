package homeworks.seaBattle.logic;

import homeworks.seaBattle.data.Configuration;
import homeworks.seaBattle.data.Ship;
import homeworks.seaBattle.data.enums.ShipType;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ShipOperations {

    private List<Ship> ships = new ArrayList<>();

    public void removeShip(Ship ship) {
        ships.remove(ship);
    }

    public List<Ship> getShips() {
        return ships;
    }

    /**
     * Method to populate the list of ships {@link ShipOperations#ships}
     */
    public void generateShips() {
        for (int i = 0; i < Configuration.getLincorNumber(); i++) {
            ships.add(new Ship(ShipType.LINCOR.getType(), Configuration.getLincorDecks()));
        }
        for (int j = 0; j < Configuration.getCruiserNumber(); j++) {
            ships.add(new Ship(ShipType.CRUISER.getType(), Configuration.getCruiserDecks()));
        }
        for (int k = 0; k < Configuration.getDestroyerNumber(); k++) {
            ships.add(new Ship(ShipType.DESTROYER.getType(), Configuration.getDestroyerDecks()));
        }
        for (int l = 0; l < Configuration.getBoatNumber(); l++) {
            ships.add(new Ship(ShipType.BOAT.getType(), Configuration.getBoatDecks()));
        }
        ships.sort(Comparator.comparingInt(Ship::getShipDecks).reversed());
    }

    /**
     * Method for printing the number of ships in the ships-list {@link ShipOperations#ships}
     */
    public void printShipsNumber() {
        long lincorCount = ships.stream().filter(ship -> ship.getShipType()
                .equals(ShipType.LINCOR.getType())).count();
        long cruiserCount = ships.stream().filter(ship -> ship.getShipType()
                .equals(ShipType.CRUISER.getType())).count();
        long destroyerCount = ships.stream().filter(ship -> ship.getShipType()
                .equals(ShipType.DESTROYER.getType())).count();
        long boatCount = ships.stream().filter(ship -> ship.getShipType()
                .equals(ShipType.BOAT.getType())).count();
        System.out.println("Enemy lincor number: " + lincorCount);
        System.out.println("Enemy cruisers number: " + cruiserCount);
        System.out.println("Enemy destroyers number: " + destroyerCount);
        System.out.println("Enemy boats number: " + boatCount);
        System.out.println();
    }
}
