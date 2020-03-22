package seabattle;

import lombok.Getter;
import java.util.ArrayList;
import static java.util.stream.IntStream.*;

@Getter
class Pole {
    private ArrayList<State> States = new ArrayList<>();

    Pole() {
        range(0, 100).forEach(i -> this.States.add(State.CLEAR));
    }

    void addHitPass(int x, int y) {
        States.set(getCellId(x, y), State.HIT);
    }

    void  addShipPart(int x, int y)
    {
        States.set(getCellId(x, y), State.DEAD);
    }

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

    int getCellId(int x, int y) {
        return 10 * y + x;
    }
}
