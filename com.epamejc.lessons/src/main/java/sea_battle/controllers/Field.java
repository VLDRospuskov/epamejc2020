package sea_battle.controllers;

public class Field {

    private final int SIZE = 10;
    private int[][] field;

    public Field() {
        field = new int[SIZE][SIZE];
    }

    public int getSIZE() {
        return SIZE;
    }

    public int[][] getField() {
        return field;
    }

}
