package sea_battle.main;

import sea_battle.utils.Colors;

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
                    s += Colors.GREEN.getColor() + " \u25CF " + Colors.MAIN.getColor();
                } else if(field[i][j] == 1) {
                    s += Colors.BLUE.getColor() + " \u25A0 " + Colors.MAIN.getColor();
                } else if (field[i][j] == 2) {
                    s += Colors.YELLOW.getColor() + " \u25CB " + Colors.MAIN.getColor();
                } else if (field[i][j] == -1) {
                    s += Colors.RED.getColor() +  " X " + Colors.MAIN.getColor();
                }
            }
            s += " " + (i + 1) + "\n";
        }

        System.out.println(s);
    }

}
