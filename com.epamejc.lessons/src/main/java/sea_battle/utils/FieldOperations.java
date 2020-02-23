package sea_battle.utils;

import sea_battle.controllers.*;

public class FieldOperations {

    public void printField(Field field) {
        String s = " A  B  C  D  E  F  G  H  I  J \n";

        for (int i = 0; i < field.getSIZE(); i++) {
            for (int j = 0; j < field.getSIZE(); j++) {
                if (field.getField()[i][j] == 0) {
                    s += " \u25CF ";
                } else if(field.getField()[i][j] == 1) {
                    s += " \u25A0 ";
                } else if (field.getField()[i][j] == 2) {
                    s += " \u25CB ";
                } else if (field.getField()[i][j] == -1) {
                    s += " X ";
                }
            }
            s += " " + (i + 1) + "\n";
        }

        System.out.println(s);
    }

}
