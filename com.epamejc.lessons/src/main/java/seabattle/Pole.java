package seabattle;

import lombok.Getter;

import java.util.ArrayList;

@Getter
class Pole {
    private ArrayList<State> States = new ArrayList<>();

    Pole() {
        // todo попробовать по другому забить массив деволтным значением
        for (int i = 0; i < 100; i++) {
            this.States.add(State.CLEAR);
        }
    }



    // to do метод который добавляет часть вражеского корабля на карту
    void  addShipPart(int x, int y)
    {
        States.set(getCellId(x, y), State.DEAD);
    }

    /**
     * переделывает координаты поля в номер яцекйки в массиве
     * @param x координата х
     * @param y координата у
     * @return возвращает ячейку в массиве
     */
    private int getCellId(int x, int y) {
        return 10 * y + x;
    }



    /**
     * выыодит на экран поле
     */
    //todo мб убрать ship
    void printPole() {
        for (int i = 0; i < States.size(); i++) {
            switch (States.get(i)) {

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
            if (i % 10 == 9) {
                System.out.println();
            }
        }
    }

    void addHitPass(int x, int y) {
        States.set(getCellId(x, y), State.HIT);
    }
}
