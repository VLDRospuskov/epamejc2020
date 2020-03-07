package homework.seabattle;

import lombok.Data;

import java.util.List;

import static homework.seabattle.Strings.*;

@Data
public class Player {

    private String name;
    private ShipsField shipsField = new ShipsField();
    private Player opponent;
    private TacticalSituation situation = new TacticalSituation();

    public void shoot(Coordinate coordinate) {
        notifyShotAnnounce(coordinate);
    }

    public void onShotAnnounced(Coordinate coordinate) {
        if (shipsField.getOwnEmptyCoordinates().contains(coordinate)) {
            notifyShotFailed(coordinate);
            return;
        }

        for (Ship ship : shipsField.getOwnActiveShips()) {
            List<Coordinate> coordinates = ship.getCoordinates();

            if (coordinates.contains(coordinate)) {
                int size = coordinates.size();

                shipsField.getOwnEmptyCoordinates().add(coordinate);

                if (size > 1) {
                    notifyShipWasDamaged(coordinate);
                    coordinates.remove(coordinate);
                    return;
                }

                if (size == 1) {
                    notifyShipWasKilled(coordinate);
                    shipsField.getOwnActiveShips().remove(ship);
                    return;
                }
            }
        }
    }

    public void onShipKilled(Coordinate lastCoordinate) {
        situation.setCoordinateState(lastCoordinate, TacticalSituation.CellState.DAMAGED);
        situation.decrementOpponentShipsCount();

        for (Coordinate coordinate : situation.searchKilledShip(lastCoordinate).getAreaCoordinates()) {
            situation.setCoordinateState(coordinate, TacticalSituation.CellState.EMPTY);
        }
    }

    public void onShipDamaged(Coordinate coordinate) {
        situation.setCoordinateState(coordinate, TacticalSituation.CellState.DAMAGED);
    }

    public void onShotFailed(Coordinate coordinate) {
        situation.setCoordinateState(coordinate, TacticalSituation.CellState.EMPTY);
    }

    private void notifyShotAnnounce(Coordinate coordinate) {
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
