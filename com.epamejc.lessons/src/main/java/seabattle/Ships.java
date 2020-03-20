package seabattle;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@NoArgsConstructor
class Ships {
    private ArrayList<ShipPart> ship = new ArrayList<>();

    /**
     * Добавляет целый корабль с коодинатами
     *
     * @param coordinates коодинаты
     */
    Ships(ArrayList<Coordinates> coordinates) {
        coordinates.forEach(coordinate -> ship.add(new ShipPart(coordinate, false)));
    }

    /**
     * метод проверяет попал ли противник в корабль. В случае попадания часта корабля, в которую попали, отмечается
     * подбитой
     * @param x координата х
     * @param y координата у
     * @return есть ли попадание
     */
    boolean isHit(int x, int y) {
        int shipSell = isThisRightShip(x, y,false);
        if (shipSell >= 0) {
            ship.set(shipSell, new ShipPart(new Coordinates(x, y), true));
            return true;
        }
        return false;
    }

    /**
     * данный метод вызвращает находится ли на данной клетке часть корабля, походясь по отдельному кораблю
     * @param x координата х
     * @param y координата у
     * @return номер ячейки массива или -1
     */
    int isThisRightShip(int x, int y,boolean hit) {
        return IntStream.range(0, ship.size())
                .filter(i -> (ship.get(i).equals(new ShipPart(new Coordinates(x, y), hit))))
                .findFirst().orElse(-1);
    }


    /**
     * @return массив коодинат корабля
     */
    ArrayList<Coordinates> getShipCoordinates() {
        return ship.stream().map(ShipPart::getCoordinates).collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * @return убит ли корабль
     */
    boolean isDead() {
        return ship.stream().allMatch(ShipPart::getHit);
    }
}



