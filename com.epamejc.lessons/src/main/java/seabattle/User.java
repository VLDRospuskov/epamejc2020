package seabattle;

import java.util.ArrayList;
import java.util.Collections;

class User {
    private ArrayList<Ships> ships = new ArrayList<>();//to do Сделать такую структуру, что бы можно было хранить количество и тип кораблей для поатвновки на доску
    private Pole myPole = new Pole();//todo delete
    private Pole enemyPole = new Pole();
    private ArrayList<Integer> shipTrue = new ArrayList<>(); //todo переименовать переменную

    User() {
        this.shipTrue.add(2);
        this.shipTrue.add(0);
        this.shipTrue.add(0);
        this.shipTrue.add(0);
    }

    public boolean isAllShipOnDesk() {
        return (Collections.max(shipTrue) == 0);
    }

    //  to do сделать метод который проверяет попал ли противник и если да отмечать у себя на карте что корабль подбит
    //todo вынести ispole отдельно
    public boolean isHit(int x, int y) {
        for (int i = 0; i < ships.size(); i++) {
                Ships ship = ships.get(i);
                if (ship.isHit(x, y)) {
                    return true;
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
    int findShipSell(int x, int y, boolean hit) {
        for (Ships ship : ships) {
            int cell = ship.isThisRightShip(x, y, hit);
            if (cell >= 0) {
                return cell;
            }
        }
        return -1;
    }

    /**
     * @param x
     * @param y
     * @return по координатам корабля возвращается убит ли корабль
     */
    //to do если мой корабль убит выстрелом противника, то отправить ему тип корабля
    public boolean isDead(int x, int y) {
        int sell = findShipSell(x, y, true);
        return ships.get(sell).isDead();
    }

    //to do если кораблей не осталось у меня то противник выиграл
    public boolean isEnemyWin() {
        for (int i = 0; i < ships.size(); i++) {
            if (!ships.get(i).isDead()) {
                return false;
            }
        }
        return true;
    }

    //todo возможность удалить корабли
    void deleteShip() {

    }

    public boolean addShip(int type, int x1, int y1, int x2, int y2) {
        int typeOfSHip = type - 1;
        if ((typeOfSHip >= 0) && (typeOfSHip <= 3) && (shipTrue.get(typeOfSHip) > 0)) {
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

    // to do Додлеать метод который проверяет рядом стоят корабли или нет
    // todo убрать повтряющиеся значения
    private boolean noShipsNearby(ArrayList<Coordinates> coordinates) {
        ArrayList<Coordinates> badCoordinates = new ArrayList<>();
        for (int i = 0; i < coordinates.size(); i++) {
            badCoordinates.addAll(CubeFromCoordinates(coordinates.get(i)));
        }
        for (int i = 0; i < badCoordinates.size(); i++) {
            if (findShipSell(badCoordinates.get(i).getX(), badCoordinates.get(i).getY(), false) != (-1)) {
                return false;
            }
        }
        return true;
    }

    private ArrayList<Coordinates> CubeFromCoordinates(Coordinates coordinates) {
        ArrayList<Coordinates> tempCoord = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int x = DigitalAround(coordinates.getX(), j);
                int y = DigitalAround(coordinates.getY(), i);
                if (inPole(x, y)) {
                    tempCoord.add(new Coordinates(x, y));
                }
            }
        }
        return tempCoord;
    }

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
        boolean b;
        int absy = Math.abs(y1 - y2);
        int absx = Math.abs(x1 - x2);
        b = ((x1 == x2) && absy == type) || ((y2 == y1) && absx == type);
        return b;
    }
    /**
     * @param x1
     * @param y1
     * @return true если заданная точка находится в поле, в противном случае false
     */
    public boolean inPole(int x1, int y1) {
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
    //to do метод который убирает один корабль из списака кораблей, которые наобходимо поставить на доску
    public void ShipSet(int type) {
        int typeOfSHip = type - 1;
        shipTrue.set((typeOfSHip), (shipTrue.get(typeOfSHip)) - 1);
        System.out.println("");
    }

    /**
     * Метод возвращает массив координат корабля, частью которого являются введенные координаты
     *
     * @param x
     * @param y
     * @return массив координат
     */
    public ArrayList<Coordinates> getShipCoordinates(int x, int y) {
        return ships.get(findShipSell(x, y, true)).getShipCoordinates();
    }

    public void addEnemyPartShipToPole(int x, int y) {
        enemyPole.addShipPart(x, y);
    }

    public void addEnemyShipToPole(ArrayList<Coordinates> ship) {
        //  enemyPole.addShip(ship);
        for (int i = 0; i < ship.size(); i++) {
            enemyPole.addShipPart(ship.get(i).getX(), ship.get(i).getY());
        }
    }

    public void printEnemyPole() {
        enemyPole.printPole();
    }

    public void hitPass(int x, int y) {
        enemyPole.addHitPass(x, y);
    }


    /*




    OLD
     */
    private boolean notOnShips(Pole pole, ArrayList<Coordinates> coordinates) {
        for (Coordinates coordinate : coordinates) {
            if (pole.getStateByXY(coordinate.getX(), coordinate.getY()) == State.SHIP) {
                return false;
            }
        }
        return true;
    }

    private boolean notOnShips1(ArrayList<Coordinates> coordinates) {
        for (int i = 0; i < coordinates.size(); i++) {
            Coordinates coordinate = coordinates.get(i);
            if (findShipSell(coordinate.getX(), coordinate.getY(), false) > -1) {
                return true;
            }
        }
        return false;
    }

}
