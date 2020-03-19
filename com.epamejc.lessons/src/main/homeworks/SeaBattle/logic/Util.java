package homeworks.SeaBattle.logic;

import homeworks.SeaBattle.data.enums.Chars;
import homeworks.SeaBattle.data.players.Computer;
import homeworks.SeaBattle.data.players.Player;
import homeworks.SeaBattle.data.players.User;

import java.awt.*;
import java.util.ArrayList;

import static homeworks.SeaBattle.logic.IO.printWaiting;

public class Util {

    public static Player generateUser() {
        String name = IO.getName();
        boolean isManualShipGeneration = IO.getShipsGenerationType(name);
        if (!isManualShipGeneration) {
            printWaiting();
        }
        return new User(name, isManualShipGeneration);
    }

    public static Player generateComputer() {
        return new Computer();
    }

    public static int convertStringToIntForShooting(String str) {
        char charY = str.toUpperCase().charAt(0);
        int y = charY - 65;
        return between0_9(y);
    }

    public static ArrayList<Point> existingCellsNear(Point p) {
        ArrayList<Point> list = getCellsAround(p);
        list.removeIf(point -> !isInField(point));
        return list;
    }

    public static boolean isPossible(Point p, Player player) {
        return isInField(p) && !isNearAShip(p, player);
    }

    private static boolean isNearAShip(Point p, Player player) {
        for (Point point : existingCellsNear(p)) {
            if (player.getField()[point.y][point.x] == Chars.SHIP.getChar()) {
                return true;
            }
        }

        return false;
    }

    public static boolean isInField(Point p) {
        return ((0 <= p.x && p.x <= 9) && (0 <= p.y && p.y <= 9));
    }


    private static ArrayList<Point> getCellsAround(Point p) {
        ArrayList<Point> list = new ArrayList<>();

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                list.add(new Point(p.x + i, p.y + j));
            }
        }

        list.remove(p);
        return list;
    }

    private static int between0_9(int y) {
        if (0 <= y && y <= 9) {
            return y;
        } else {
            throw new RuntimeException();
        }
    }

}
