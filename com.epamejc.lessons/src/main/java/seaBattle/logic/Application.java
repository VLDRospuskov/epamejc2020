package seaBattle.logic;

import seaBattle.data.Cell;
import seaBattle.data.CellStatus;
import seaBattle.data.Ship;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 0.1
 * @author Andrew Nuzha
 */
public class Application {

    private int fieldSize = 10;


    private List<Cell> playerField = new ArrayList<>();
    private List<Cell> botField = new ArrayList<>();
    private List<Ship> playerShips = new ArrayList<>();
    private List<Ship> botShips = new ArrayList<>();

    public Application(){
        //прочитать конфиг?
    }

    public void run() {
        System.out.println("Welcome to seabattle game ver 0.1\n");
        // 1. сгенерили поля
        generateField(playerField);
        generateField(botField);
        // 2. сгенерили список кораблей
        ShipOperator shipOperator = new ShipOperator(1, 2 , 3, 4);
        shipOperator.generateShips();
        shipOperator.placeShipsAutomatically(playerField, botField);

        FieldPrinter fieldPrinter = new FieldPrinter(fieldSize);
        fieldPrinter.printField(playerField,botField);
        //setShips(playerShips);
    }

    private void generateField (List<Cell> cellsList) {

        int cellIndex = 0;
        for (int i = 1; i <= fieldSize; i++) {
            for (int j = 1; j <= fieldSize; j++) { ;
                cellsList.add(new Cell(cellIndex, i, j, CellStatus.HIDDEN.getStatus()));
                cellIndex++;
            }
        }
    }

}
