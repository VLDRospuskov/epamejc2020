package homework.seabattle.actors;

import homework.seabattle.model.Coordinate;
import homework.seabattle.model.ShipsField;
import homework.seabattle.model.TacticalSituation;
import homework.seabattle.model.ships.Ship;

import static homework.seabattle.config.Config.*;
import static homework.seabattle.config.Strings.*;
import static homework.seabattle.view.Printer.printShipsOnMap;

abstract public class Player {

    public enum Type {
        HUMAN,
        COMPUTER
    }

    protected String name;

    protected ShipsField shipsField = new ShipsField();

    protected Player opponent;

    protected TacticalSituation situation = new TacticalSituation();

    public static Player create(Type type) {
        if (type.equals(Type.HUMAN)) {
            return new User();
        } else if (type.equals(Type.COMPUTER)) {
            return new Bot();
        }
        throw new RuntimeException("Undefined player type");
    }

    public void setOpponent(Player opponent) {
        this.opponent = opponent;
    }

    public String getName() {
        return name;
    }

    public ShipsField getShipsField() {
        return shipsField;
    }

    public abstract void createName();

    abstract protected void addShip(int length);

    abstract protected void shoot();

    public void createShipsLocation() {
        addShip(4);

        for (int i = 0; i < THREEDECKS_SHIPS_COUNT; i++) {
            addShip(3);
        }

        for (int i = 0; i < TWODECKS_SHIPS_COUNT; i++) {
            addShip(2);
        }

        for (int i = 0; i < ONEDECK_SHIPS_COUNT; i++) {
            addShip(1);
        }

        System.out.println("\n" + name + YOUR_SHIPS);
        printShipsOnMap(shipsField.getOwnActiveShips(), shipsField.getOwnEmptyCoordinates());
    }

    public void startGame() {
        shoot();
    }

    public void onShotAnnounced(Coordinate coordinate) {
        if (shipsField.containsEmptyCoordinate(coordinate)) {
            notifyShotFailed(coordinate);
            shoot();
            return;
        }

        for (Ship ship : shipsField.getOwnActiveShips()) {
            if (ship.contains(coordinate)) {
                shipsField.addEmptyCoordinate(coordinate);
                ship.removeCoordinate(coordinate);

                if (ship.isValid()) {
                    notifyShipWasDamaged(coordinate);
                    return;
                }

                shipsField.removeActiveShip(ship);
                notifyShipWasKilled(coordinate);
                return;
            }
        }
    }

    public void onShipKilled(Coordinate lastCoordinate) {
        situation.decrementOpponentShipsCount();
        if (situation.getOpponentActiveShipsCount() == 0) {
            System.out.println(name + WIN);
            return;
        }

        situation.setCellState(lastCoordinate, TacticalSituation.CellState.DAMAGED);

        for (Coordinate coordinate : situation.searchShip(lastCoordinate).getAreaCoordinates()) {
            situation.setCellState(coordinate, TacticalSituation.CellState.EMPTY);
        }

        shoot();
    }

    public void onShipDamaged(Coordinate coordinate) {
        situation.setCellState(coordinate, TacticalSituation.CellState.DAMAGED);
        shoot();
    }

    public void onShotFailed(Coordinate coordinate) {
        situation.setCellState(coordinate, TacticalSituation.CellState.EMPTY);
    }

    protected void notifyShotAnnounce(Coordinate coordinate) {
        opponent.onShotAnnounced(coordinate);
    }

    private void notifyShipWasKilled(Coordinate lastCoordinate) {
        System.out.println(ANSWER_KILLED);
        opponent.onShipKilled(lastCoordinate);
    }

    private void notifyShipWasDamaged(Coordinate coordinate) {
        System.out.println(ANSWER_DAMAGED);
        opponent.onShipDamaged(coordinate);
    }

    private void notifyShotFailed(Coordinate coordinate) {
        System.out.println(ANSWER_MISSED);
        opponent.onShotFailed(coordinate);
    }
}
