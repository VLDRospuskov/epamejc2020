package seabattle.players;

import seabattle.gameField.BattleField;


import java.util.HashSet;

public class CompPlayer implements Player {

    BattleField compField = new BattleField(new String[11][11]);
    Ship compNavy = new Ship(new HashSet<>());


    @Override
    public void setShips() {
        compNavy.fourDeckShip = startCreateShip(4);
        compNavy.threeDeckShip1 = startCreateShip(3);
        compNavy.threeDeckShip2 =  startCreateShip(3);
        compNavy.twoDeckShip1 = startCreateShip(2);
        compNavy.twoDeckShip2 = startCreateShip(2);
        compNavy.twoDeckShip3 = startCreateShip(2);
        compNavy.oneDeckShip1 = startCreateShip(1);
        compNavy.oneDeckShip2 = startCreateShip(1);
        compNavy.oneDeckShip3 = startCreateShip(1);
        compNavy.oneDeckShip4 = startCreateShip(1);
//        compField.drawField("    Comp battlefield"); -  вывести на экран корабли компьютера
    }


    Integer[][] startCreateShip(int decksAmount) {
        Integer[][] ship;
        while (true) {
            ship = generateRandomCoordinate(decksAmount);
            String shipWay = generateRandomShipWay();

            if (Ship.putShipCheck(ship, shipWay)) {
                Ship.createShip(ship, shipWay);
                break;
            }
        }
        drawShip(ship);
        return ship;
    }


    Integer[][] generateRandomCoordinate(int decksAmount) {
        Integer[][] firstDeckCoor = new Integer[decksAmount][2];
        firstDeckCoor[0][0] = (int) (1 + Math.random() * 10);
        firstDeckCoor[0][1] = (int) (1 + Math.random() * 10);
        return firstDeckCoor;
    }


    String generateRandomShipWay() {
        String[] ways = new String[]{"up", "down", "left", "right"};
        return ways[(int) (Math.random() * 4)];
    }


    void drawShip(Integer[][] ship) {
        for (Integer[] integers : ship) {
            compField.battleField[integers[0]][integers[1]] = String.valueOf((char) 9632);
        }
    }

    @Override
    public void shoot() {
    }
}
