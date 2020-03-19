package seabattle;

import java.util.ArrayList;
import java.util.Collections;

class User {
    private ArrayList<Ships> ships = new ArrayList<>();//todo Сделать такую структуру, что бы можно было хранить количество и тип кораблей для поатвновки на доску
    private Pole myPole = new Pole();
    private Pole enemyPole = new Pole();
    private ArrayList<Integer> shipTrue = new ArrayList<>(); //todo переименовать переменную

    User() {
        this.shipTrue.add(4);
        this.shipTrue.add(3);
        this.shipTrue.add(2);
        this.shipTrue.add(1);
    }

    public boolean isAllShipOnDesk() {
        return (Collections.max(shipTrue) == 0);
    }

    // todo сделать метод который проверяет попал ли противник и если да отмечать у себя на карте что корабль подбит
    //todo вынести ispole отдельно
    public boolean isHit(int x, int y) {
        if (inPole(x, y)) {
            for (int i = 0; i < ships.size(); i++) {
                Ships ship = ships.get(i);
                if (ship.isHit(x, y)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * данный метод вызвращает находится ли на данной клетке часть корабля
     *
     * @param x
     * @param y
     * @return если есть то возвращается яцейка в ships, где находится корабль если нет то -1
     */
    int findShipSell(int x, int y) {
        for (Ships ship : ships) {
            int cell = ship.isThisRightShip(x, y);
            if (cell >= 0) {
                return cell;
            }
        }
        return -1;
    }


    //todo если мой корабль убит выстрелом противника, то отправить ему тип корабля
    public boolean isDead(int x, int y) {
        int sell = findShipSell(x,y);
        if (ships.get(sell).isDead())




        return false;


    }

    //todo если кораблей не осталось у меня то противник выиграл
    public boolean isEnemyWin() {
        return false;
    }

    //todo возможность удалить корабли
    void deleteShip() {

    }


    public boolean addShip(int type, int x1, int y1, int x2, int y2) {
        if (shipTrue.get(type) > 0) {
            if (isCorrectCoords(type, x1, y1, x2, y2) && (inPole(x2, y2) && (inPole(x1, y1)))) {
                ArrayList<Coordinates> coordinates = makeCoordinates(x1, y1, x2, y2);
                if (notOnShips(myPole, coordinates) && noShipsNearby(myPole, coordinates)) {
                    ships.add(new Ships(coordinates));
                    shipTrue.set(type, (shipTrue.get(type) - 1));
                    return true;
                }
            }
        }
        return false;
    }

    // todo Додлеать метод который проверяет рядом стоят корабли или нет
    private boolean noShipsNearby(Pole pole, ArrayList<Coordinates> coordinates) {
        return true;
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

    private boolean notOnShips(Pole pole, ArrayList<Coordinates> coordinates) {
        for (Coordinates coordinate : coordinates) {
            if (pole.getStateByXY(coordinate.getX(), coordinate.getY()) == State.SHIP) {
                return false;
            }
        }
        return true;
    }

    private boolean notOnShips1(ArrayList<Coordinates> coordinates) {
        for (Coordinates coordinate : coordinates) {
            if (findShipSell(coordinate.getX(), coordinate.getY()) > -1) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param x1
     * @param y1
     * @return true если заданная точка находится в поле, в противном случае false
     */
    private boolean inPole(int x1, int y1) {
        return ((x1 >= 0) && (x1 < 10) && (y1 >= 0) && (y1 < 10));
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
        int type;
        if (x1 == x2) {
            type = y2 - y1 + 1;
            for (int i = 0; i < type; i++) {
                coordinates.add(new Coordinates(x1, y1 + i));
            }
        } else {
            type = x2 - x1 + 1;
            for (int i = 0; i < type; i++) {
                coordinates.add(new Coordinates(x1 + i, y1));
            }
        }
        return coordinates;
    }

    /**
     * Метод уменьшает количество кораблей введеного типа, которые надо поставить
     *
     * @param type размерность корабля
     */
    //todo метод который убирает один корабль из списака кораблей, которые наобходимо поставить на доску
    public void ShipSet(int type) {
        shipTrue.set(type, (shipTrue.get(type)) - 1);
    }

    /**
     * Метод возвращает массив координат корабля, частью которого являются введенные координаты
     *
     * @param x
     * @param y
     * @return массив координат
     */
    public ArrayList<Coordinates> getShipCoordinates(int x, int y) {
        return ships.get(findShipSell(x, y)).getShipCoordinates();
    }

    public void addEnemyPartShipToPole(int x, int y) {
        enemyPole.addShipPart(x, y);
    }

    public void addEnemyShipToPole(ArrayList<Coordinates> ship) {
        enemyPole.addShip(ship);
    }

    public void printEnemyPole() {
        enemyPole.printPole();
    }

    public void hitPass(int x, int y) {
        enemyPole.addHitPass(x, y);
    }


}
