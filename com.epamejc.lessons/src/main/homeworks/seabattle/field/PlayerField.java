package main.homeworks.seabattle.field;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

@Data
public class PlayerField {

    private String name;
    private char[][] fieldArray;

    private Integer[][] cellShipIdArray;
    private ArrayList<Ship> ships;
    private HashMap<Integer, Ship> shipHashMap;
    private Boolean placingShipsFlag;

    public final static Character emptyCell = ' ';
    public final static Character shipChar = 'o';
    public final static Character blowChar = '*';
    public final static Character missedChar = 'x';
    public final static ArrayList<Character> letters = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'k', 'l', 'm', 'n'));

    public int size = 10;


    public PlayerField(int fieldSize, String name) {
        ships = new ArrayList<>();
        shipHashMap = new HashMap<>();
        this.name = name;
        size = fieldSize;
        fieldArray = new char[size][size];
        cellShipIdArray = new Integer[size][size];
        placingShipsFlag = true;
        beginPlay();
    }

    public PlayerField(String name) {
        ships = new ArrayList<>();
        shipHashMap = new HashMap<>();
        this.name = name;
        fieldArray = new char[10][10];
        cellShipIdArray = new Integer[10][10];
        placingShipsFlag = true;
        beginPlay();
    }

    public void beginPlay() {
        /*
         * Initialize empty field array
         * Using a separate method in case there is something else supposed to be happening when the game begins
         */
        this.cleanFieldArray();
        this.draw();
    }

    public void cleanFieldArray() {
        int size = fieldArray.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                fieldArray[i][j] = ' ';
                cellShipIdArray[i][j] = -1;
            }
        }
    }

    public void draw() {

        System.out.println("____________________");
        System.out.println("     " + this.name + "     ");
        System.out.println("____________________");

        System.out.print("   ");
        for (int i = 0; i < size; i++) {
            System.out.print(letters.get(i));
            System.out.print("  ");
        }

        System.out.println();

        for (int i = 1; i <= size; i++) {
            if (i == 10) {
                System.out.print(i + "|");
            } else {
                System.out.print(i + " |");
            }

            for (int j = 0; j < size; j++) {
                if (placingShipsFlag || fieldArray[i - 1][j] != shipChar) {
                    System.out.print(fieldArray[i - 1][j] + " |");
                } else {
                    System.out.print("  |");
                }

            }
            System.out.println();
        }
        System.out.println("____________________");
        System.out.println();
    }

    /**
     * Used to update the field
     *
     * @param x         - x coordinate (passed as a character) which needs to be updated
     * @param y         - y coordinate which need to be updated
     * @param character - character which need to be put on the map (e.g. X for an explosion, o for a part of the ship)
     */
    public void update(Character x, int y, char character) {
        int xToInt = letters.indexOf(x);
        y--;
        fieldArray[y][xToInt] = character;
        draw();
    }

    public void addShip(Ship ship) {
        ships.add(ship);

        int locX = letters.indexOf(ship.getLocX());
        int locY = ship.getLocY() - 1;
        int length = ship.getLength();
        int direction = ship.getDirection();

        if (direction == 0) {
            for (int i = locX; i < length + locX; i++) {
                fieldArray[locY][i] = shipChar;
                cellShipIdArray[locY][i] = ship.getShipId();
            }
            shipHashMap.put(ship.getShipId(), ship);
            draw();
        }

        if (direction == 1) {
            for (int i = locY; i < length + locY; i++) {
                fieldArray[i][locX] = shipChar;
                cellShipIdArray[i][locX] = ship.getShipId();
            }
            shipHashMap.put(ship.getShipId(), ship);
            draw();
        }
    }

    public Boolean isInGrid(int x, int y) {
        if (x < 0 || y < 0) {
            return false;
        }
        return x < size && y < size;
    }

    public Boolean isThereShipCellAround(Character x, int y) {
        int xToInt = letters.indexOf(x);
        y--;
        if (isInGrid(y + 1, xToInt + 1) && fieldArray[y + 1][xToInt + 1] == shipChar) return true;
        if (isInGrid(y, xToInt + 1) && fieldArray[y][xToInt + 1] == shipChar) return true;
        if (isInGrid(y - 1, xToInt + 1) && fieldArray[y - 1][xToInt + 1] == shipChar) return true;
        if (isInGrid(y - 1, xToInt) && fieldArray[y - 1][xToInt] == shipChar) return true;
        if (isInGrid(y - 1, xToInt - 1) && fieldArray[y - 1][xToInt - 1] == shipChar) return true;
        if (isInGrid(y, xToInt - 1) && fieldArray[y][xToInt - 1] == shipChar) return true;
        if (isInGrid(y + 1, xToInt - 1) && fieldArray[y + 1][xToInt - 1] == shipChar) return true;
        if (isInGrid(y - 1, xToInt) && fieldArray[y + 1][xToInt] == shipChar) return true;

        return false;
    }

    public Boolean isShipHit(Character x, int y) {
        int xToInt = letters.indexOf(x);
        y--;

        return fieldArray[y][xToInt] == shipChar;
    }

    public void handleShipHit(Character letter, int number) {
        update(letter, number, blowChar);
        Integer cellId = cellShipIdArray[number - 1][letters.indexOf(letter)];
        Ship hitShip = shipHashMap.get(cellId);
        hitShip.handleGetHit();
    }

    public void handleShotMissed(Character letter, int number) {
        update(letter, number, missedChar);
    }

}
