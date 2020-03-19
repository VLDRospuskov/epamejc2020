package seabattle;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
class Pole {
    private ArrayList<State> States = new ArrayList<>();

    Pole() {
        // todo попробовать по другому забить массив деволтным значением
        for (int i = 0; i < 100; i++) {
            this.States.add(State.CLEAR);
        }
    }

    /**
     * метод добавляет на поле противника убитый корабль
     * @param coordinates координаты корабля
     */
    void addShip(ArrayList<Coordinates> coordinates) {
        for (Coordinates coordinate : coordinates) {
            States.set(getCellId(coordinate.getX(), coordinate.getY()), State.DEAD);
        }
    }
    // todo метод который добавляет часть вражеского корабля на карту
    void  addShipPart(int x, int y)
    {

    }

    /**
     * переделывает координаты поля в номер яцекйки в массиве
     * @param x
     * @param y
     * @return возвращает ячейку в массиве
     */
    int getCellId(int x, int y) {
        return 10 * y + x;
    }

    /**
     * Возвращает статус ячейки поля по координатам
     * @param x
     * @param y
     * @return статус
     */
    State getStateByXY(int x, int y) {
        return States.get(getCellId(x, y));
    }

    /**
     * выыодит на экран поле
     */
    void printPole() {
        for (int i = 0; i < States.size(); i++) {
            switch (States.get(i)) {
                case SHIP:
                    System.out.print("S");
                    break;
                case HIT:
                    System.out.print("H");
                    break;
                case CLEAR:
                    System.out.print("C");
                    break;
                case DEAD:
                    System.out.print("D");
                    break;
            }
            if (i % 10 == 0) {
                System.out.println("");
            }
        }
    }

    public void addHitPass(int x, int y) {
    }
}
