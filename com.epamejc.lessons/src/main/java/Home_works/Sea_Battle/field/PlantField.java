package Home_works.Sea_Battle.field;

import Home_works.Sea_Battle.ships.CoordinatesList;

public class PlantField {
    public String[][] getPlant(String[][] field, CoordinatesList coordinatesList) {
        for (int i = 0; i < coordinatesList.getList().size(); i++) {
            int x = coordinatesList.getList().get(i).getX();
            int y = coordinatesList.getList().get(i).getY();
            field[x][y] = coordinatesList.getList().get(i).getValue();
        }
        return field;
    }
}
