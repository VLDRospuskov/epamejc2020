package Home_works.Sea_Battle.ships;

import java.util.ArrayList;
import java.util.List;

public class CoordinatesList {
    private List<Coordinates> list = new ArrayList<>();

    public CoordinatesList() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                list.add(new Coordinates(i, j, "."));
            }
        }
    }

    public List<Coordinates> getList() {
        return list;
    }

    public int getElement(int x, int y) {
        for (int i = 0; i < list.size(); i++) {
            Coordinates coordinat = list.get(i);
            if (coordinat.getX() == x & coordinat.getY() == y) {
                return i;
            }
        }
        return -1;
    }

    public void cleaningFalseValue() {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setFlag(true);
        }
    }
}
