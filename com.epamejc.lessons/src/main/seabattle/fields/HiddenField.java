package main.seabattle.fields;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HiddenField extends Field {

    private char[][] helpArr;
    private final int nHelp;

    public HiddenField() {
        nHelp = n + 2;
        helpArr = fillFieldClean(nHelp);
    }

    public void createShipsAutomatic() {
        createShip(4);
        createShip(3);
        createShip(3);
        createShip(2);
        createShip(2);
        createShip(2);
        createShip(1);
        createShip(1);
        createShip(1);
        createShip(1);
    }

    public void createShip(int length) {
        List<Integer> list = new ArrayList<>();
        int vertical = (int) (Math.random() * 2);
        if (vertical == 1) {
            list = createVerticalOptions(list, length);
        } else {
            list = createHorizontalOptions(list, length);
        }
        Collections.shuffle(list);
        int row = list.get(0) % 10;
        int column = list.get(0) / 10;
        putShip(row, column, length, vertical);
        createNotAvailableZone(row, column, length, vertical);
    }

    public boolean attack(int i, int j) {
        boolean hit = false;
        if (arr[i][j] == boat) {
            hit = true;
            arr[i][j] = got;
        } else {
            arr[i][j] = away;
        }
        return hit;
    }

    protected List<Integer> createVerticalOptions(List<Integer> list, int length) {
        for (int i = 1; i <= (n - length); i++) {
            for (int j = 1; j <= 10; j++) {
                switch (length) {
                    case 1:
                        if (helpArr[i][j] != boat) {
                            list.add((i - 1) + 10 * (j - 1));
                        }
                        break;
                    case 2:
                        if (helpArr[i][j] != boat && helpArr[i + 1][j] != boat) {
                            list.add((i - 1) + 10 * (j - 1));
                        }
                        break;
                    case 3:
                        if (helpArr[i][j] != boat && helpArr[i + 1][j] != boat && helpArr[i + 2][j] != boat) {
                            list.add((i - 1) + 10 * (j - 1));
                        }
                        break;
                    case 4:
                        if (helpArr[i][j] != boat && helpArr[i + 1][j] != boat &&
                                helpArr[i + 2][j] != boat && helpArr[i + 3][j] != boat) {
                            list.add((i - 1) + 10 * (j - 1));
                        }
                        break;
                }

            }
        }
        return list;
    }

    protected List<Integer> createHorizontalOptions(List<Integer> list, int length) {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= (n - length); j++) {
                switch (length) {
                    case 1:
                        if (helpArr[i][j] != boat) {
                            list.add((i - 1) + 10 * (j - 1));
                        }
                        break;
                    case 2:
                        if (helpArr[i][j] != boat && helpArr[i][j + 1] != boat) {
                            list.add((i - 1) + 10 * (j - 1));
                        }
                        break;
                    case 3:
                        if (helpArr[i][j] != boat && helpArr[i][j + 1] != boat && helpArr[i][j + 2] != boat) {
                            list.add((i - 1) + 10 * (j - 1));
                        }
                        break;
                    case 4:
                        if (helpArr[i][j] != boat && helpArr[i][j + 1] != boat &&
                                helpArr[i][j + 2] != boat && helpArr[i][j + 3] != boat) {
                            list.add((i - 1) + 10 * (j - 1));
                        }
                        break;
                }
            }
        }
        return list;
    }

    protected void putShip(int row, int column, int length, int vertical) {
        for (int i = 0; i < length; i++) {
            if (vertical == 1) {
                arr[row + i][column] = boat;
            } else {
                arr[row][column + i] = boat;
            }
        }
    }

    protected void createNotAvailableZone(int row, int column, int length, int vertical) {
        int lengthZone = length + 2;
        int a = 3;
        int b = 3;
        if (vertical == 1) {
            a = lengthZone;
        } else {
            b = lengthZone;
        }
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                helpArr[row + i][column + j] = boat;
            }
        }
    }

}
