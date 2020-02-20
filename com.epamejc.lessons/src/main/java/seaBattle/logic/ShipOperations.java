package seaBattle.logic;

import seaBattle.data.Configuration;
import seaBattle.data.Ship;
import seaBattle.data.enums.ShipType;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ShipOperations {

    private List<Ship> ships = new ArrayList<>();

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

    public void removeShip(Ship ship) {
        ships.remove(ship);
    }

    public List<Ship> getShips() {
        return ships;
    }

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
