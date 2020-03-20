package main.seabattle.fields;

import main.seabattle.decor.Decks;

import java.util.Scanner;

import static main.seabattle.decor.Colours.*;

public class CustomField extends HiddenField {

    public void createShipsManually() {
        Scanner scanner = new Scanner(System.in);
        int numberShips = 1;
        int index = 3;
        printField("custom");
        do {
            for (int i = 0; i < numberShips; i++) {
                boolean valueISOk;
                int row;
                int column;
                int vertical = 0;
                do {
                    System.out.print(GREEN + "Enter point for " + Decks.values()[index] + " desk ship: " + RESET);
                    row = scanner.nextInt();
                    column = scanner.nextInt();
                    if (index != 0) {
                        System.out.print(GREEN + "Vertical or horizontal? " +
                                "(Enter 1 for vertical or 0 for horizontal): " + RESET);
                        vertical = scanner.nextInt();
                    }
                    valueISOk = legalIndexes(row, column, index + 1, vertical);
                } while (!valueISOk);
                putShip(row, column, index + 1, vertical);
                printField("custom");
            }
            numberShips++;
            index--;
        } while (index >= 0);
    }

    public boolean legalIndexes(int row, int column, int length, int vertical) {
        try {
            if (vertical == 1) {
                if (row + length > 10) {
                    throw new IllegalArgumentException();
                }
            } else {
                if (column + length > 10) {
                    throw new IllegalArgumentException();
                }
            }
            if (row > 9 || row < 0 || column > 9 || column < 0) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(GREEN + "You entered not valid indexes." + RESET);
            return false;
        }
        return true;
    }

}
