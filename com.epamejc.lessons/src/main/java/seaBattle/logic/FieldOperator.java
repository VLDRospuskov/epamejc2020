package seaBattle.logic;

import seaBattle.data.Cell;
import seaBattle.data.CellStatus;

import java.util.ArrayList;
import java.util.List;

public class FieldOperator {

    private List<Cell> playerField = new ArrayList<>();
    private List<Cell> botField = new ArrayList<>();
    private int fieldSize;

    public FieldOperator(int fieldSize){
        this.fieldSize = fieldSize;
    }

    public List<Cell> getPlayerField() {
        return playerField;
    }

    public List<Cell> getBotField() {
        return botField;
    }

    public void generateFields () {
        int cellIndex = 0;
        for (int i = 1; i <= fieldSize; i++) {
            for (int j = 1; j <= fieldSize; j++) { ;
                playerField.add(new Cell(cellIndex, i, j, CellStatus.HIDDEN.getStatus()));
                cellIndex++;
            }
        }
        cellIndex = 0;
        for (int i = 1; i <= fieldSize; i++) {
            for (int j = 1; j <= fieldSize; j++) { ;
                botField.add(new Cell(cellIndex, i, j, CellStatus.HIDDEN.getStatus()));
                cellIndex++;
            }
        }
    }

    public Cell getFreeCell(int xCoord, int yCoord, List<Cell> field){
        Cell selectedCell = field.stream()
                .filter(cell -> cell.getxCoord() == xCoord
                        && cell.getyCoord() == yCoord && cell.getCellStatus() == CellStatus.HIDDEN.getStatus())
                .findAny()
                .orElse(null);
        return selectedCell;
    }

    public boolean checkBorder(int xCoord, int yCoord, List<Cell> field, String direction, int shipDecks) {
        Cell checkCell = null;
        switch(direction){
            case "up" :
                checkCell = getFreeCell(xCoord, yCoord - shipDecks + 1, field);
                break;
            case "right":
                checkCell = getFreeCell(xCoord + shipDecks - 1, yCoord, field);
                break;
            case "down" :
                checkCell = getFreeCell(xCoord, yCoord + shipDecks - 1, field);
                break;
            case "left":
                checkCell = getFreeCell(xCoord - shipDecks + 1, yCoord, field);
                break;
        }
        if (checkCell == null) {
            return false;
        } else {
            return true;
        }
    }

//    public boolean checkAnotherShips() {
//
//    }

    public List<Cell> getCellsInRadius (int xCoord, int yCoord, String direction, List<Cell> field, int shipDecks) {
        List<Cell> checkList = new ArrayList<>();
        checkList = ModulesOperator.getModuleUp(xCoord, yCoord, shipDecks, field);
        switch(direction){
            case "up" :
                checkList = ModulesOperator.getModuleUp(xCoord, yCoord, shipDecks, field);
                break;
            case "right":
//                checkCell = getFreeCell(xCoord + shipDecks - 1, yCoord, field);
//                break;
            case "down" :
//                checkCell = getFreeCell(xCoord, yCoord + shipDecks - 1, field);
//                break;
            case "left":
//                checkCell = getFreeCell(xCoord - shipDecks + 1, yCoord, field);
//                break;
        }
        return checkList;
    }


}
