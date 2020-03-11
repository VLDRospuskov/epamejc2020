package homeworks.seabatle.model.board;


import homeworks.seabatle.exception.ShipCreationRequestException;
import homeworks.seabatle.exception.ShipNotFoundException;
import homeworks.seabatle.model.ship.Ship;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Custom collection for ships
 */
public class PlayerShipsRepository implements ShipsRepository {
    private List<Ship> ships;
    private static final String SUCCESS = " successfully added!";

    public PlayerShipsRepository() {
        ships = new LinkedList<>();
    }

    /**
     * @param coordinate is between 0 and 99
     * @return Ship if there is a ship in ships, which contains coordinate param;
     * @throws ShipNotFoundException if something crash in logic
     */
    @Override
    public Ship getShip(int coordinate) throws ShipNotFoundException {
        return ships.stream()
                .filter(ship -> containsCoords(ship, coordinate))
                .findFirst()
                .orElseThrow(() -> new ShipNotFoundException("something was wrong"));
    }

    /**
     * method, that add ship to collection
     *
     * @param ship is completed ship from auto or manual factories
     *             uses inShipZone method to check
     * @return success message, if ship was added to ships
     * @throws ShipCreationRequestException if ship can`t be added
     */
    @Override
    public String addShip(Ship ship) throws ShipCreationRequestException {
        for (Ship inListShip : ships) {
            if (inShipZone(inListShip, ship)) {
                throw new ShipCreationRequestException("You can't create ship here, there" +
                        " is another ship in this location");
            }
        }
        ships.add(ship);
        return ship.getType() + SUCCESS;
    }

    /**
     * method, that swap ship in collection with its updated version
     *
     * @param ship is a ship with updated condition in field service
     */
    @Override
    public void updateShip(Ship ship) {
        int ind = -1;
        for (Ship inListShip : ships) {
            if (inListShip.getId() == ship.getId()) {
                ind = ships.indexOf(inListShip);
            }
        }
        if (ind != -1) {
            ships.set(ind, ship);
        }
    }

    /**
     * @return List of ships
     */
    @Override
    public List<Ship> getAll() {
        return ships;
    }

    /**
     * @return amount of ships remains in repository
     */
    @Override
    public int getSize() {
        return ships.size();
    }

    /**
     * removes ship from repository
     */
    @Override
    public void delete(Ship ship) {
        ships.remove(ship);
    }

    private boolean inShipZone(Ship repShip, Ship ship) {
        return inShipZone(repShip.getCoords(), ship.getCoords());
    }

    /**
     * method compares 2 arrays. We say that ship is in another ship zone
     * if one coordinate in repShip differ from coordinate in another ship less then 2
     *
     * @param repShip     array of coords of ship, that contains in repository
     * @param anotherShip array of coords of ship, we need to check
     * @return if one coordinate in repShip differ from coordinate in another ship less then 2 else return false
     */
    private boolean inShipZone(int[] repShip, int[] anotherShip) {
        boolean answer = false;
        for (int value : repShip) {
            int x1 = value / 10;
            int y1 = value % 10;
            for (int i : anotherShip) {
                int x2 = i / 10;
                int y2 = i % 10;
                if (Math.abs(x2 - x1) <= 1 && Math.abs(y2 - y1) <= 1) {
                    answer = true;
                }
            }
        }
        return answer;
    }

    /**
     * method check if ship is placed on request coordinate
     *
     * @param ship       ship, that contains in repository
     * @param coordinate coordinate we need to check
     * @return true if contains, false if not
     */
    private boolean containsCoords(Ship ship, int coordinate) {
        return containsCoords(ship.getCoords(), coordinate);
    }

    /**
     * method check if array contains a coordinate
     *
     * @param coords     array of coords of ship, that contains in repository
     * @param coordinate coordinate we need to check
     * @return true if contains, false if not
     */
    private boolean containsCoords(int[] coords, int coordinate) {
        return Arrays.stream(coords).anyMatch(n -> n == coordinate);
    }

}
