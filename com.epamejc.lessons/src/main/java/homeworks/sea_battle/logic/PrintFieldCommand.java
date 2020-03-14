package homeworks.sea_battle.logic;

import homeworks.sea_battle.enums.Colors;

public class PrintFieldCommand {

    public static void printField(int[][] field) {
        StringBuilder s = new StringBuilder(" A  B  C  D  E  F  G  H  I  J \n");

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[i][j] == 0) {
                    s.append(Colors.GREEN.getColor()).append(" \u25CF ").append(Colors.MAIN.getColor());
                } else if(field[i][j] == 1) {
                    s.append(Colors.BLUE.getColor()).append(" \u25A0 ").append(Colors.MAIN.getColor());
                } else if (field[i][j] == 2) {
                    s.append(Colors.YELLOW.getColor()).append(" \u25CB ").append(Colors.MAIN.getColor());
                } else if (field[i][j] == -1) {
                    s.append(Colors.RED.getColor()).append(" X ").append(Colors.MAIN.getColor());
                }
            }
            s.append(" ").append(i + 1).append("\n");
        }

        System.out.println(s);
    }

}
