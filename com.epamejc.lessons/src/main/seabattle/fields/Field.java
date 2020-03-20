package main.seabattle.fields;

import static main.seabattle.decor.Colours.*;
import static main.seabattle.decor.Inscriptions.*;

public class Field {

    protected char[][] arr;
    protected final int n = 10;
    protected final char got = 'X';
    protected final char away = 'U';
    protected final char clean = 'O';
    protected final char boat = 'T';

    public Field() {
        arr = fillFieldClean(n);
    }

    public char[][] fillFieldClean(int n) {
        char[][] array = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = clean;
            }
        }
        return array;
    }

    public void printField(String title) {
        if (title.equals("custom")) {
            printMyField();
        } else if (title.equals("computer")) {
            printComputersField();
        }
        System.out.print(PURPLE + " ");
        for (int i = 0; i < 10; i++) {
            System.out.print("  " + i);
        }
        System.out.println(RESET);
        for (int i = 0; i < n; i++) {
            System.out.print(PURPLE + i + "  " + RESET);
            for (int j = 0; j < n; j++) {
                switch (arr[i][j]) {
                    case got:
                        System.out.print(RED + arr[i][j] + "  " + RESET);
                        break;
                    case away:
                        System.out.print(BLUE + arr[i][j] + "  " + RESET);
                        break;
                    case boat:
                        System.out.print(YELLOW + arr[i][j] + "  " + RESET);
                        break;
                    default:
                        System.out.print(WHITE + arr[i][j] + "  ");
                }
            }
            System.out.println();
        }
    }

}
