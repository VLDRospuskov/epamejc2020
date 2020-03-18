package homeworks.newSeabattle.logic;

import homeworks.newSeabattle.data.players.Computer;
import homeworks.newSeabattle.data.players.Player;
import homeworks.newSeabattle.data.players.User;

import java.awt.*;

public class Util {

    public static Player generateUser() {
        String name = IO.getNameFromUser();
        return new User(name);
    }

    public static Player generateComputer() {
        return new Computer();
    }

    public static int between0_9(int y) {
        if (0 <= y && y <= 9) {
            return y;
        } else {
            throw new RuntimeException();
        }
    }

    public static Point getComputerSmartShoot() {
        int x = (int) (Math.random() * 10);
        int y = (int) (Math.random() * 10);
        return new Point(x, y);
    }

}
