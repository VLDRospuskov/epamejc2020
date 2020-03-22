package seabattle;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@NoArgsConstructor
class Ships {
    private ArrayList<ShipPart> ship = new ArrayList<>();

    Ships(ArrayList<Coordinates> coordinates) {
        coordinates.forEach(coordinate -> ship.add(new ShipPart(coordinate, false)));
    }

    boolean isHit(int x, int y) {
        int shipSell = isThisRightShip(x, y,false);
        if (shipSell >= 0) {
            ship.set(shipSell, new ShipPart(new Coordinates(x, y), true));
            return true;
        }
        return false;
    }

    boolean isDead() {
        return ship.stream().allMatch(ShipPart::getHit);
    }

    int isThisRightShip(int x, int y,boolean hit) {
        return IntStream.range(0, ship.size())
                .filter(i -> (ship.get(i).equals(new ShipPart(new Coordinates(x, y), hit))))
                .findFirst().orElse(-1);
    }

    ArrayList<Coordinates> getShipCoordinates() {
        return ship.stream().map(ShipPart::getCoordinates).collect(Collectors.toCollection(ArrayList::new));
    }
}



