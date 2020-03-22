package seabattle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.IntStream;

class User {
    private ArrayList<Ships> ships = new ArrayList<>();
    private Pole enemyPole = new Pole();
    private ArrayList<Integer> RemainingShips = new ArrayList<>();

    /**
     * Создает массив с кораблями, которые осталось поставить
     */
    User() {
        this.RemainingShips.add(Settings.SHIP_TYPE_1_COUNT);
        this.RemainingShips.add(Settings.SHIP_TYPE_2_COUNT);
        this.RemainingShips.add(Settings.SHIP_TYPE_3_COUNT);
        this.RemainingShips.add(Settings.SHIP_TYPE_4_COUNT);
    }

    /**
     * @return все ли корабли осталось поставить на игровое поле
     */
    boolean isAllShipOnDesk() {
        return (Collections.max(RemainingShips) == 0);
    }

    /**
     * @param x коодината х
     * @param y коордианат у
     * @return было ли попадание в корабль по координатам
     */
    boolean isHit(int x, int y) {
         return ships.stream().anyMatch(ship -> ship.isHit(x, y));
    }

    /**
     * @param x координата х
     * @param y координата у
     * @return по координатам корабля возвращается убит ли корабль
     */
    boolean isDead(int x, int y) {
        return ships.get(findShipSell(x, y, true)).isDead();
    }

    /**
     * @return не осталось ли кораблей на поле игрока и не выиграл ли противник
     */
    boolean isEnemyWin() {
        return IntStream.range(0, ships.size()).allMatch(i -> ships.get(i).isDead());
    }

    /**
     * Метод добавляющий корабль на поле игрока
     *
     * @param type тип корабля
     * @param x1   начальная коодината х
     * @param y1   начальная коодината у
     * @param x2   конечная координата х
     * @param y2   конечная координата у
     * @return добавлен кораль или нет
     */
    boolean addShip(int type, int x1, int y1, int x2, int y2) {
        int typeOfSHip = type - 1;
        if ((typeOfSHip >= 0) && (typeOfSHip <= 3) && (RemainingShips.get(typeOfSHip) > 0)) {
            if (isCorrectCoords(typeOfSHip, x1, y1, x2, y2) && (inPole(x2, y2) && (inPole(x1, y1)))) {
                ArrayList<Coordinates> coordinates = makeCoordinates(x1, y1, x2, y2);
                if (noShipsNearby(coordinates)) {
                    ships.add(new Ships(coordinates));
                    return true;
                }
                return false;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * выводит после противника
     */
    void printEnemyPole() {
        System.out.println(enemyPole.printPole());
    }

    /**
     * @param x координата х
     * @param y координата y
     * @return true если заданная точка находится в поле, в противном случае false
     */
    boolean inPole(int x, int y) {
        return (x >= 0 && (x < 10) && (y >= 0) && (y < 10));
    }

    /**
     * Метод уменьшает количество кораблей введеного типа, которые надо поставить
     *
     * @param type размерность корабля
     */

    void ShipSet(int type) {
        int typeOfSHip = type - 1;
        RemainingShips.set((typeOfSHip), (RemainingShips.get(typeOfSHip)) - 1);
    }

    /**
     * Метод возвращает массив координат корабля, частью которого являются введенные координаты
     *
     * @param x координата х
     * @param y координата у
     * @return массив координат
     */
    ArrayList<Coordinates> getShipCoordinates(int x, int y) {
        return ships.get(findShipSell(x, y, true)).getShipCoordinates();
    }

    /**
     * добавляет подбитую часть вражеского корабля на поле игрока
     *
     * @param x координата х
     * @param y координата у
     */
    void addEnemyPartShipToPole(int x, int y) {
        enemyPole.addShipPart(x, y);
    }

    /**
     * добавляет убитый корабль противника на поле игрока
     *
     * @param ship координаты корабля
     */
    void addEnemyShipToPole(ArrayList<Coordinates> ship) {
        ship.forEach(coordinates -> enemyPole.addShipPart(coordinates.getX(), coordinates.getY()));
    }

    /**
     * добавляет промах на карту игрока
     *
     * @param x координата х
     * @param y координата у
     */
    void hitPass(int x, int y) {
        enemyPole.addHitPass(x, y);
    }

    /**
     * данный метод вызвращает находится ли на данной клетке часть корабля
     * @param x координата х
     * @param y координата у
     * @return если есть то возвращается яцейка в ships, где находится корабль если нет то -1
     */
    private int findShipSell(int x, int y, boolean hit) {
        return ships.stream().mapToInt(ship -> ship.isThisRightShip(x, y, hit))
                .filter(cell -> cell >= 0).findFirst().orElse(-1);
    }

    /**
     * @param coordinates координаты корабля
     * @return нет ли рядом в радиусе 1 клетки союзного корабля
     */
    private boolean noShipsNearby(ArrayList<Coordinates> coordinates) {
        ArrayList<Coordinates> badCoordinates = new ArrayList<>();
        coordinates.stream().map(this::CubeFromCoordinates).forEach(badCoordinates::addAll);
        return badCoordinates.stream()
                .noneMatch(badCoordinate
                        -> findShipSell(badCoordinate.getX(), badCoordinate.getY(), false) != (-1));
    }

    /**
     * @param coordinates Координаты корабля
     * @return координаты корабля и одна клетка от него
     */
    private ArrayList<Coordinates> CubeFromCoordinates(Coordinates coordinates) {
        ArrayList<Coordinates> tempCoords = new ArrayList<>();
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                int x = DigitalAround(coordinates.getX(), j);
                int y = DigitalAround(coordinates.getY(), i);
                if ((inPole(x, y))&&!(tempCoords.contains(new Coordinates(x, y)))) {
                    tempCoords.add(new Coordinates(x, y));
                }
            }
        return tempCoords;
    }

    /**
     * @param d число
     * @param i позиция
     * @return измененное число в зависимости от его позиции
     */
    private int DigitalAround(int d, int i) {
        switch (i) {
            case 1:
                return d;
            case 2:
                return d + 1;
            default:
                return d - 1;
        }
    }

    /**
     * @param type размерность корабля
     * @param x1   координата Х начала корабля
     * @param y1   координата У начала корабля
     * @param x2   координата Х конца корабля
     * @param y2   координата У конца корабля
     * @return если координаты правильно введены возвращает положительное значение,
     * в противном случае отрицательнок
     */
    private boolean isCorrectCoords(int type, int x1, int y1, int x2, int y2) {
        return ((x1 == x2) && Math.abs(y1 - y2) == type) || ((y2 == y1) && Math.abs(x1 - x2) == type);

    }

    /**
     * метод конвертирует координаты начала и конца корабля в массив координат
     * каждого элемента корабля
     *
     * @param x1 координата Х начала корабля
     * @param y1 координата У начала корабля
     * @param x2 координата Х конца корабля
     * @param y2 координата У конца корабля
     * @return массив координат корабля
     */
    private ArrayList<Coordinates> makeCoordinates(int x1, int y1, int x2, int y2) {
        ArrayList<Coordinates> coordinates = new ArrayList<>();
        if (x1 > x2) {
            int t = x1;
            x1 = x2;
            x2 = t;
        }
        if (y1 > y2) {
            int t = y1;
            y1 = y2;
            y2 = t;
        }
        int type;
        if (x1 == x2) {
            type = y2 - y1 + 1;
            for (int i = 0; i < type; i++) {
                coordinates.add(new Coordinates(x1, y1 + i));
            }
        } else {
            type = x2 - x1 + 1;
            for (int i = 0; i < type; i++) coordinates.add(new Coordinates(x1 + i, y1));
        }
        return coordinates;
    }

}
