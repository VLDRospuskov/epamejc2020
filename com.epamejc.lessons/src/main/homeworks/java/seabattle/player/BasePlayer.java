package homeworks.java.seabattle.player;

import homeworks.java.seabattle.battle.Game;
import homeworks.java.seabattle.field.Coordinatepointer;
import homeworks.java.seabattle.field.Field;
import homeworks.java.seabattle.field.ship.DeckNumberCount;
import homeworks.java.seabattle.field.ship.Ship;
import homeworks.java.seabattle.input.Orientation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BasePlayer {

    protected Game game;
    protected Field field;

    protected Map<DeckNumberCount, Integer> shipCounter;
    protected List<Ship> ships;

    protected int maxShips;
    protected int aliveShips;
    protected ShipFiller filler;

    public BasePlayer(Game game) {
        this.game = game;
        this.field = new Field();

        init();
    }

    public final void init() {
        maxShips = 0;
        aliveShips = 0;
        filler = new ShipFiller(this);
        shipCounter = new HashMap<>();

        for (int i = 1; i < DeckNumberCount.values().length; ++i) {

            int shipCount = 5 - i;

            shipCounter.put(DeckNumberCount.valueOf(i), shipCount);
            maxShips += shipCount;
        }
        if (maxShips > 0) {
            ships = new ArrayList<>();
        }
    }

    public int getFreePlace(DeckNumberCount dc) {
        return shipCounter.get(dc);
    }

    public boolean isPosibleToPlace(Orientation orient, DeckNumberCount dc, Coordinatepointer startCoord) {

        Coordinatepointer step = orient.getDirection();

        boolean isPossibleToPlace = true;

        Coordinatepointer position = new Coordinatepointer(startCoord.x, startCoord.y);

        for (int i = 0; i < dc.getValue(); ++i) {

            isPossibleToPlace = field.isValidCoordinate(position) &&
                    !field.isCollide(position) &&
                    !field.hasNeighbours(position);

            if (!isPossibleToPlace) {
                break;
            }

            position.x = position.x + step.x;
            position.y = position.y + step.y;
        }

        return isPossibleToPlace;
    }

    public boolean addShip(Orientation orient, DeckNumberCount dc, Coordinatepointer startCoord) {
        int freePlaces = getFreePlace(dc);

        if (freePlaces > 0) {
            Coordinatepointer[] coords = Ship.getCoordsForShip(field, dc, orient, startCoord);

            if (coords == null) {
                return false;
            }

            Ship ship = new Ship(field, dc, orient, coords);
            ships.add(ship);
            freePlaces -= 1;
            shipCounter.replace(dc, freePlaces);
            aliveShips++;

            return true;
        }

        return false;
    }

    public void process() {
        field.draw();
    }

    public boolean isFieldFilled() {
        return maxShips == ships.size();
    }

    public int getAliveShips() {
        return aliveShips;
    }

}
