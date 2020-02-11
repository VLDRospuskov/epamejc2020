package seaBattle.logic;

import seaBattle.data.Cell;
import seaBattle.data.Ship;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @version 0.1
 * @author Andrew Nuzha
 */
public class Application {

    private int fieldSize = 10;
    private int lincorNumber = 1;
    private int cruiserNumber = 2;
    private int destroyerNumber = 3;
    private int tBoatNumber = 4;

    private List<Cell> playerField = new ArrayList<>();
    private List<Cell> botField = new ArrayList<>();
    private List<Ship> playerShips = new ArrayList<>();
    private List<Ship> botShips = new ArrayList<>();

    public void run() {
        System.out.println("Welcome to seabattle game ver 0.1\n");
        generateField(playerField);
        generateField(botField);
        generateShips(playerShips);
        generateShips(botShips);
        System.out.println("Player field\n");
        printField(playerField);
        setShips(playerShips);
    }

    private void generateField (List<Cell> cellsList) {

        int cellIndex = 0;
        for (int i = 1; i <= fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                char yCoord = (char)(65 + j);
                cellsList.add(new Cell(cellIndex, i, yCoord, "hidden"));
                cellIndex++;
            }
        }
    }

    private void printField(List<Cell> field){
        for (int i = 0; i < fieldSize; i++){
            if (i == 0){
                System.out.print("  ");
            }
            System.out.print("  " + (char)(65 + i));
        }
        System.out.println();

        int cellIndex = 0;
        for (int i = 1; i <= fieldSize; i++){
            if (i == 10){
                System.out.print(i + " ");
            } else {
                System.out.print(i + "  ");
            }

            for (int j = 1; j <= fieldSize; j++){
                Cell c = field.get(cellIndex);
                if (c.getCellStatus() == "hidden"){
                    System.out.print(" . ");
                } else if (c.getCellStatus() == "hit") {
                    System.out.print("X");
                } else {
                    System.out.print("O");
                }
            }
            System.out.print("   " + i + "  ");
            System.out.print(" .  .  .  . ");
            System.out.println();
        }
    }

    public void generateShips(List<Ship> ships){
        for (int i = 0; i < lincorNumber; i++){
            ships.add(new Ship("lincor",4));
        }
        for (int j = 0; j < cruiserNumber; j++){
            ships.add(new Ship("cruiser", 3));
        }
        for (int k = 0; k < destroyerNumber; k++){
            ships.add(new Ship("destroyer",2));
        }
        for (int l = 0; l < tBoatNumber; l++){
            ships.add(new Ship("tBoat",1));
        }
    }

    //Пока для простоты тестим только расстановку одной лодки
    public void setShips(List<Ship> ships){
        //разместили корабль - далее вокруг него всем ячейкам выставляем флаг занята

        generateRandomInt(fieldSize);
    }

    private void placeShip(Ship ship){
        //размещаем корабль на координатах
    }

    public int generateRandomInt(int fieldSize){
        Random rand = new Random();
        int randomNum = rand.nextInt((fieldSize - 1) + 1) + 1;
        return randomNum;
    }
}
