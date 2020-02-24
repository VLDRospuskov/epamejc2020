package homeworks.seabattle;

import homeworks.utility.helper.Helper;
import lombok.SneakyThrows;

import java.awt.*;

public class Game {

    @SneakyThrows
    public Point getPointFromUser() {
        String input = Helper.getString("Input (a1 format): ");
        int x = Integer.parseInt(input.substring(1)) - 1;
        int y = convertStringToInt(input.substring(0, 1));
        return new Point(x, y);
    }

    private int convertStringToInt(String yString) {
        char charY = yString.toUpperCase().charAt(0);
        int y = charY - 65;
        return between0_9(y);
    }

    private int between0_9(int y) {
        if (0 <= y && y <= 9) {
            return y;
        } else {
            throw new RuntimeException();
        }
    }

}
