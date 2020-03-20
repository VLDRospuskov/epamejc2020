package seabattle;

import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
class Ships {
    private ArrayList<ShipPart> ship = new ArrayList<>();

    Ships(ArrayList<Coordinates> coordinates) {
        for (Coordinates coordinate : coordinates) {
            ship.add(new ShipPart(coordinate, false));
        }
    }

    /**
     * метод проверяет попал ли противник в корабль. В случае попадания часта корабля, в которую попали, отмечается
     * подбитой
     * @param x
     * @param y
     * @return
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
     * @param x
     * @param y
     * @return номер ячейки массива или -1
     */
    int isThisRightShip(int x, int y,boolean hit) {
        for (int i = 0; i < ship.size(); i++) {
            if ((ship.get(i).equals(new ShipPart(new Coordinates(x, y), hit)))) {
                return i;
            }
        }
        return -1;
    }


    public ArrayList<Coordinates> getShipCoordinates() {
        ArrayList<Coordinates> shipCoordinates = new ArrayList<>();
        for (int i = 0; i < ship.size(); i++) {
            shipCoordinates.add(ship.get(i).getCoordinates());
        }
        return shipCoordinates;
    }

    /**
     * @return убит ли корабль
     */
    public boolean isDead() {
        for(int i=0;i<ship.size();i++)
        {
            if(!ship.get(i).getHit())
            {
                return false;
            }
        }
        return true;
    }
}



