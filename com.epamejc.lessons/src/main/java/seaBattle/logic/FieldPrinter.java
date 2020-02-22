package seaBattle.logic;

import seaBattle.data.Cell;
import seaBattle.data.Configuration;
import seaBattle.data.enums.CellStatus;
import seaBattle.data.enums.ConsoleColors;

import java.util.List;
import java.util.stream.Collectors;

public class FieldPrinter {

    private int fieldSize = Configuration.getFieldSize();

    //Метод для печати игрового поля
    public void printDoubleField(List<Cell> playerField, List<Cell> botField) {
        printDoubleFieldHead();

        for (int i = 1; i <= fieldSize; i++) {
            printDoubleFieldLine(playerField, botField, i);
        }
        System.out.println();
    }

    public void printSingleField(List<Cell> playerField) {
        printSingleFieldHead();
        for (int i = 1; i <= fieldSize; i++) {
            printSingleFieldLine(playerField, i);
        }
        System.out.println();
    }

    private void printSingleFieldHead() {
        System.out.println();
        for (int i = 0; i < fieldSize; i++) {
            if (i == 0) {
                System.out.print("   ");
            }
            System.out.print("  " + ConsoleColors.GREEN_BOLD.color() +
                    (char) (65 + i) + ConsoleColors.RESET.color());
        }
        System.out.println();
    }

    //Метод печатает шапку игрового поля
    private void printDoubleFieldHead() {
        System.out.println();
        System.out.println("\t\t\tPlayers field \t\t\t\t\t\tComputer field\n");
        for (int i = 0; i < fieldSize; i++) {
            if (i == 0) {
                System.out.print("   ");
            }
            System.out.print("  " + ConsoleColors.GREEN_BOLD.color() +
                    (char) (65 + i) + ConsoleColors.RESET.color());
        }
        System.out.print("\t");
        for (int i = 0; i < fieldSize; i++) {
            if (i == 0) {
                System.out.print("   ");
            }
            System.out.print("  " + ConsoleColors.GREEN_BOLD.color() +
                    (char) (65 + i) + ConsoleColors.RESET.color());
        }
        System.out.println();
    }

    private void printSingleFieldLine(List<Cell> playerField, int yCoord) {
        System.out.print(ConsoleColors.GREEN_BOLD.color() + yCoord + ConsoleColors.RESET.color() + "\t");
        printHumanFieldInitialization(playerField, yCoord);
        System.out.println();
    }

    //Метод печатает строку ячеек под указанным индексом строки
    private void printDoubleFieldLine(List<Cell> playerField, List<Cell> botField, int yCoord) {
        System.out.print(ConsoleColors.GREEN_BOLD.color() + yCoord + ConsoleColors.RESET.color() + "\t");
        printHumanFieldComponents(playerField, yCoord);
        System.out.print("\t");
        System.out.print(ConsoleColors.GREEN_BOLD.color() + yCoord + ConsoleColors.RESET.color() + "\t");
        printBotFieldComponents(botField, yCoord);
        System.out.println();
    }

    //Метод вытаскивает элементы из листа по индексу строки и печатает в зависимости от их статуса
    private void printHumanFieldComponents(List<Cell> printingField, int yCoord) {
        List<Cell> filteredList =
                printingField.stream().filter(cell -> cell.getyCoord() == yCoord).collect(Collectors.toList());

        for (Cell c : filteredList) {
            if (c.getCellShip() != null && c.getCellStatus().equals(CellStatus.HIT.getStatus())) {
                System.out.print(ConsoleColors.RED.color() + " X " + ConsoleColors.RESET.color());
            } else if (c.getCellShip() != null) {
                System.out.print(" □ ");
            } else if (c.getCellStatus().equals(CellStatus.HIDDEN.getStatus())) {
                System.out.print(" . ");
            } else if (c.getCellStatus().equals(CellStatus.HIT.getStatus())){
                System.out.print(ConsoleColors.RED.color() + " X " + ConsoleColors.RESET.color());
            } else if (c.getCellStatus().equals(CellStatus.MISSED.getStatus())) {
                System.out.print(ConsoleColors.BLUE.color() + " O " + ConsoleColors.RESET.color());
            }
        }
    }

    private void printHumanFieldInitialization(List<Cell> printingField, int yCoord) {
        List<Cell> filteredList =
                printingField.stream().filter(cell -> cell.getyCoord() == yCoord).collect(Collectors.toList());

        for (Cell c : filteredList) {
            if (c.isInitializationCell()){
                System.out.print(ConsoleColors.GREEN.color() + " □ " + ConsoleColors.RESET.color());
            } else if (c.getCellShip() != null) {
                System.out.print(" □ ");
            } else if (c.getCellStatus().equals(CellStatus.HIDDEN.getStatus())) {
                System.out.print(" . ");
            }
        }
    }

    private void printBotFieldComponents(List<Cell> printingField, int yCoord) {
        List<Cell> filteredList =
                printingField.stream().filter(cell -> cell.getyCoord() == yCoord).collect(Collectors.toList());

        for (Cell c : filteredList) {
            if (c.getCellStatus().equals(CellStatus.HIDDEN.getStatus())) {
                System.out.print(" . ");
            } else if (c.getCellStatus().equals(CellStatus.HIT.getStatus())) {
                System.out.print(ConsoleColors.RED.color() + " X " + ConsoleColors.RESET.color());
            } else if (c.getCellStatus().equals(CellStatus.MISSED.getStatus())) {
                System.out.print(ConsoleColors.BLUE.color() + " O " + ConsoleColors.RESET.color());
            }
        }
    }
}
