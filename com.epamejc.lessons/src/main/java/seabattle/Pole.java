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
     * Добавляет промых на поле по координатам
     * @param x координата х
     * @param y кордината у
     */
    void addHitPass(int x, int y) {
        States.set(getCellId(x, y), State.HIT);
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
     * выыодит на поле на экран
     */
    String printPole() {
        StringBuilder out= new StringBuilder();
        for (int i = 0; i < States.size(); i++) {
            switch (States.get(i)) {

                case HIT:
                    out.append("H");

                    break;
                case CLEAR:
                    out.append("C");

                    break;
                case DEAD:
                    out.append("D");

                    break;
            }
            if (i % 10 == 9) {
                System.out.print("\r\n");
            }
        }
        return out.toString();
    }

    /**
     * переделывает координаты поля в номер яцекйки в массиве
     * @param x координата х
     * @param y координата у
     * @return возвращает ячейку в массиве
     */
    int getCellId(int x, int y) {
        return 10 * y + x;
    }
}
