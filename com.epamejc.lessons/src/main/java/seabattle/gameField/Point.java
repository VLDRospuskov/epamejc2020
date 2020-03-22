package seabattle.gameField;

import lombok.Data;

import java.util.ArrayList;

/**
 * The class in which points are created. Each point corresponds to one cell of the playing field.
 * Point stores information about the current status of the cell.
 * Класс, в котором создаются пойнты. Каждый пойнт соответствует одной клетке игрового поля.
 * Пойнт хранит информацию о текущем статусе клетки.
 */
@Data
public class Point {

    int xCoordinate;
    int yCoordinate;
    FieldStatus pointStatus;
    ArrayList<Point> pointSet;

    public Point(int xCoordinate, int yCoordinate, FieldStatus pointStatus) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.pointStatus = pointStatus;

    }


    public static ArrayList<Point> pointFilling() {
        ArrayList<Point> pointSet = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            pointSet.add(new Point(0, 0, null));
        }

        int k = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                pointSet.get(k).xCoordinate = i + 1;
                pointSet.get(k).yCoordinate = j + 1;
                pointSet.get(k).pointStatus = FieldStatus.CLEAR;
                k++;
            }
        }
        return pointSet;
    }


    @Override
    public String toString() {
        return "Point{" +
                "xCoordinate='" + xCoordinate + '\'' +
                ", yCoordinate='" + yCoordinate + '\'' +
                ", pointStatus=" + pointStatus +
                '}';
    }


    public static void deckToField(ArrayList<Point> pointSet, Integer[][] ship) {
        for (Point point : pointSet) {
            for (int i = 0; i < ship.length; i++) {
                if (ship[i][0] == point.getXCoordinate()) {
                    for (int j = 0; j < 2; j++) {
                        if (ship[i][j] == point.getYCoordinate()) {
                            point.pointStatus = FieldStatus.DECK;
                        }
                    }
                }
            }
        }
    }
}
