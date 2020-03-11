package homeworks.seabatle.model.board;


import homeworks.seabatle.functional.StringMaker;
import homeworks.seabatle.model.ship.Ship;
import homeworks.seabatle.myenum.StrikeResult;
import homeworks.seabatle.servises.locationservice.ShipAreaCreatorImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Field {
    private ShipsRepository fleet;
    private String[][] matrix;
    private final static int BORDER = 10;
    private final static String WATER = "~";
    private final static String DECK = "@";
    private final static String KILLED = "X";
    private final static String EMPTY = "*";
    private final static String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
    private final static String[] indexis = {" ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    private Function<Integer, Integer> del;
    private Function<Integer, Integer> rem;
    private StringMaker maker;

    public Field(ShipsRepository fleet) {
        this.fleet = fleet;
        del = coordinate -> coordinate / BORDER;
        rem = coordinate -> coordinate % BORDER;
        matrix = new String[BORDER][BORDER];
        maker = string -> string + " ";
        createField();
        locateShips();
    }

    /**
     * @param coordinate integer from 0 to 99
     * @return enum, containing information about strike result
     */
    public StrikeResult getStrikeRes(int coordinate) {
        int x = del.apply(coordinate);
        int y = rem.apply(coordinate);
        return getStrikeRes(x, y);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getHat());
        sb.append("\n");
        for (int i = 0; i < matrix.length; i++) {
            sb.append(maker.make(letters[i]));
            for (int j = 0; j < matrix[i].length; j++) {
                sb.append(maker.make(matrix[i][j]));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * @return list of strings, contains visual information
     * of battle field condition
     */
    public List<String> getFieldArray() {
        List<String> fieldMap = new ArrayList<>();
        fieldMap.add(getHat());
        for (int i = 0; i < matrix.length; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(maker.make(letters[i]));
            for (int j = 0; j < matrix[i].length; j++) {
                sb.append(maker.make(matrix[i][j]));
            }
            fieldMap.add(sb.toString());
        }
        return fieldMap;
    }

    /**
     * @return string with with indexes from 1 to 10
     */
    private String getHat() {
        String hat = Arrays
                .stream(indexis)
                .map(s -> maker.make(s))
                .collect(Collectors.joining());
        return hat.substring(0, hat.length() - 1);
    }

    /**
     * method use matrix
     *
     * @param x - vertical coordinate
     * @param y - horizontal coordinate
     * @return enum, contains information about strike result
     */
    private StrikeResult getStrikeRes(int x, int y) {
        String square = matrix[x][y];
        updateField(x, y);
        if (square.equals(DECK)) {
            Ship ship = fleet.getShip(x * 10 + y);
            ship.decrementLives();
            fleet.updateShip(ship);
            if (ship.getLives() > 0) {
                return StrikeResult.WOUND;
            } else {
                fleet.delete(ship);
                afterKillUpdate(ship.getCoords());
                if (fleet.getSize() > 0) {
                    return StrikeResult.KILL;
                } else {
                    return StrikeResult.LOSE;
                }
            }
        } else if (square.equals(KILLED) || square.equals(EMPTY)) {
            return StrikeResult.SHOOT;
        } else {
            return StrikeResult.MISS;
        }
    }

    /**
     * update fields condition
     *
     * @param x coordinate from 0 to 9
     * @param y coordinate from 0 to 9
     */
    private void updateField(int x, int y) {
        if (isInRange(x, y)) {
            String target = matrix[x][y];
            if (target.equals(DECK)) {
                matrix[x][y] = KILLED;
            } else if (target.equals(WATER)) {
                matrix[x][y] = EMPTY;
            }

        }
    }

    /**
     * method creates field without ships
     */
    private void createField() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = WATER;
            }
        }
    }

    /**
     * method places ships on there positions
     */
    private void locateShips() {
        for (Ship ship : fleet.getAll()) {
            int[] coords = ship.getCoords();
            for (int coord : coords) {
                setCell(del.apply(coord), rem.apply(coord));
            }
        }
    }

    /**
     * method places deck on its position
     */
    private void setCell(int x, int y) {
        matrix[x][y] = DECK;
    }

    /**
     * make area around ship marked
     */
    private void afterKillUpdate(int[] coords) {
        List<Integer> area = new ArrayList<>();
        ShipAreaCreatorImpl creator = new ShipAreaCreatorImpl();
        for (int coord : coords) {
            area.addAll(creator.getCrossArea(coord));
            area.addAll(creator.getDiagonalArea(coord));
        }
        afterKillUpdate(area);

    }

    /**
     * method updates the visualization and data after killing ship
     * @param area is list of coordinates of ship and area
     *             around it
     */
    private void afterKillUpdate(List<Integer> area) {
        for (int coord : area) {
            int x = del.apply(coord);
            int y = rem.apply(coord);
            afterKillUpdate(x, y);
        }
    }

    /**
     * method switches visual interpritation of cell condition(change from "water" to "empty")
     * @param x integer from 0 to 9
     * @param y integer from 0 to 9
     */
    private void afterKillUpdate(int x, int y) {
        if (isInRange(x, y)) {
            String target = matrix[x][y];
            if (target.equals(WATER)) {
                matrix[x][y] = EMPTY;
            }
        }
    }

    /**
     *
     * @param x - integer from 0 to 9
     * @param y - integer from 0 to 9
     * @return true if x and y in range of 0 and 9
     */
    private boolean isInRange(int x, int y) {
        return 0 <= x && x <= 9 && 0 <= y && y <= 9;
    }

}
