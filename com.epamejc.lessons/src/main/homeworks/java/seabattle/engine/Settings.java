package homeworks.java.seabattle.engine;

import homeworks.java.seabattle.data.Ship;
import homeworks.java.seabattle.data.enums.Ships;

import java.util.ArrayList;
import java.util.List;

public class Settings {

    private int deckSize = 10;
    private int cruisersCount = 1;
    private int cruisersSize = 4;
    private int destroyersCount = 2;
    private int destroyersSize = 3;
    private int corvetteCount = 3;
    private int corvetteSize = 2;
    private int boatCount = 4;
    private int boatSize = 1;
    private List<Ship> ships;

    public List<Ship> getShipsList() {

        ships = new ArrayList<>();
        addShipsByType(cruisersCount, cruisersSize, Ships.CRUISER);
        addShipsByType(destroyersCount, destroyersSize, Ships.DESTROYER);
        addShipsByType(corvetteCount, corvetteSize, Ships.CORVETTE);
        addShipsByType(boatCount, boatSize, Ships.BOAT);
        return ships;

    }

    public int getDeckSize() {

        return deckSize;

    }

    public int getTheBiggestShip() {

        int first = Integer.max(cruisersSize, destroyersSize);
        int second = Integer.max(corvetteSize, boatSize);
        return Integer.max(first, second);

    }

    private void addShipsByType(int count, int length, Ships type) {

        for (int i = 0; i < count; i++) {
            ships.add(new Ship(type, length));
        }

    }

}
