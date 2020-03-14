package homeworks.sea_battle.data;

public class Field {

    private final int SIZE = 10;

    private int[][] field;

    public Field() {
        this.field = new int[SIZE][SIZE];
    }

    public int getSIZE() {
        return SIZE;
    }

    public int[][] getField() {
        return field;
    }

}
