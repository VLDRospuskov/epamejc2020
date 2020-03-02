package sea_battle.main;

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

    public void printField() {
        String s = " A  B  C  D  E  F  G  H  I  J \n";

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[i][j] == 0) {
                    s += " \u25CF ";
                } else if(field[i][j] == 1) {
                    s += " \u25A0 ";
                } else if (field[i][j] == 2) {
                    s += " \u25CB ";
                } else if (field[i][j] == -1) {
                    s += " X ";
                }
            }
            s += " " + (i + 1) + "\n";
        }

        System.out.println(s);
    }

}
