package main.seaBattle.logic;

import main.seaBattle.data.Cell;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private List<Cell> playerField = new ArrayList<>();
    private List<Cell> botField = new ArrayList<>();
    private int fieldSize = 10; //потом инициализировать его в конфиге

    public void run() {
        generateField(playerField);
        String stopHere = "here";
        //1.прочитать конфиг
        //2. генерим поля (2 поля по 100 ячеек)
        //3. расстановка кораблей (пока что рандомно для бота и человека)
        //4. начало игры
        //4.1. ход человека.
    }

    private void readConfig() {

    }

    private void generateField (List<Cell> cellsList) {
        int cellIndex = 0;
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 1; j <= fieldSize; j++) {
                char yCoord = (char)(65 + i);
                cellsList.add(new Cell(cellIndex, j, yCoord, "hidden"));
                cellIndex++;
            }
        }

    }
}
