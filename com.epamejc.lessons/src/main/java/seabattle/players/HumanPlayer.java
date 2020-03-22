package seabattle.players;

import seabattle.gameField.BattleField;
import seabattle.gameField.Point;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;


public class HumanPlayer implements Player {

    BattleField humanField = new BattleField(new String[11][11]);
    Ship humanNavy = new Ship(new HashSet<>());
    ArrayList<Point> humanPoints = Point.pointFilling();

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    @Override
    public void setShips() throws IOException {

//        System.out.println(humanPoints);  - проверка, как выводится начальный список пойнтов человека

        humanField.drawField("    Your battlefield");

        System.out.println("Enter the coordinates (first a number, then a letter, example: '1 a') of the FIRST deck of the four-deck ship.");
        humanNavy.fourDeckShip = inputCoordinates(4);

//        System.out.println(humanPoints); - проверка, как первый корабль записан в список пойнтов

        System.out.println("Enter the coordinates (first a number, then a letter, example: '1 a') of the FIRST deck of the first three-deck ship.");
        humanNavy.threeDeckShip1 = inputCoordinates(3);
        System.out.println("Enter the coordinates (first a number, then a letter, example: '1 a') of the FIRST deck of the second three-deck ship.");
        humanNavy.threeDeckShip2 = inputCoordinates(3);

        System.out.println("Enter the coordinates (first a number, then a letter, example: '1 a') of the FIRST deck of the first two-deck ship.");
        humanNavy.twoDeckShip1 = inputCoordinates(2);
        System.out.println("Enter the coordinates (first a number, then a letter, example: '1 a') of the FIRST deck of the second two-deck ship.");
        humanNavy.twoDeckShip2 = inputCoordinates(2);
        System.out.println("Enter the coordinates (first a number, then a letter, example: '1 a') of the FIRST deck of the third two-deck ship.");
        humanNavy.twoDeckShip3 = inputCoordinates(2);

        System.out.println("Enter the coordinates (first a number, then a letter, example: '1 a') of the FIRST deck of the first one-deck ship.");
        humanNavy.oneDeckShip1 = inputCoordinates(1);
        System.out.println("Enter the coordinates (first a number, then a letter, example: '1 a') of the FIRST deck of the second one-deck ship.");
        humanNavy.oneDeckShip2 = inputCoordinates(1);
        System.out.println("Enter the coordinates (first a number, then a letter, example: '1 a') of the FIRST deck of the third one-deck ship.");
        humanNavy.oneDeckShip3 = inputCoordinates(1);
        System.out.println("Enter the coordinates (first a number, then a letter, example: '1 a') of the FIRST deck of the fourth one-deck ship.");
        humanNavy.oneDeckShip4 = inputCoordinates(1);
    }


    Integer[][] inputCoordinates(int decksAmount) throws IOException {
        Integer[][] shipCoord;

        String[][] inputCoord = new String[decksAmount][2];

        while (true) {
            inputCoord[0] = reader.readLine().split(" ");

            inputCoord[0][1] = renameSecondCoordinate(inputCoord[0][1]);

            shipCoord = parseCoordinatesToInt(inputCoord);

            System.out.println("Enter way of the ship (up, down, left, or right)");
            String route = reader.readLine();

            if (Ship.putShipCheck(shipCoord, route)) {
                Ship.createShip(shipCoord, route);
                break;
            } else {
                System.out.println("Incorrect input. Try again.");
            }
        }
        Point.deckToField(humanPoints, shipCoord);
        drawShip(shipCoord);
        return shipCoord;
    }


    String renameSecondCoordinate(String letter) {
        String secondCoordinate = "";
        for (int i = 97; i <= 105; i++) {
            if (letter.equals(String.valueOf((char) i))) {
                secondCoordinate = String.valueOf((char) (i - 48));
                break;
            }
        }
        if (letter.equals(String.valueOf((char) 106))) {
            secondCoordinate = "10";
        }
        return secondCoordinate;
    }


    Integer[][] parseCoordinatesToInt(String[][] inputCoord) {
        Integer[][] coordinates = new Integer[inputCoord.length][2];
        coordinates[0][0] = Integer.parseInt(inputCoord[0][0]);
        coordinates[0][1] = Integer.parseInt(inputCoord[0][1]);
        return coordinates;
    }


    void drawShip(Integer[][] ship) {
        for (Integer[] integers : ship) {
            humanField.battleField[integers[0]][integers[1]] = String.valueOf((char) 9632);
        }
        humanField.drawField("    Your battlefield");
    }


    @Override
    public void shoot() {
    }
}

