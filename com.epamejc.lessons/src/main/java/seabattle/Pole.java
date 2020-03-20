package seabattle;

import lombok.Getter;

import java.util.ArrayList;


import static java.util.stream.IntStream.*;


@Getter
class Pole {
    private ArrayList<State> States = new ArrayList<>();

    /**
     * Заполняет поле чистыми значениями
     */
    Pole() {
        range(0, 100).forEach(i -> this.States.add(State.CLEAR));
    }


    /**
     * Добавляет подбитую часть корабля на поле
     * @param x координата х
     * @param y координата у
     */
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
     * выыодит на поле на экран
     */
    void printPole() {
        range(0, States.size()).forEach(i -> {
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
        });
    }


    /**
     * Добавляет промых на поле по координатам
     * @param x координата х
     * @param y кордината у
     */
    void addHitPass(int x, int y) {
        States.set(getCellId(x, y), State.HIT);
    }
}
