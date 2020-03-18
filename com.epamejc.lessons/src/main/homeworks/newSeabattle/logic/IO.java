package homeworks.newSeabattle.logic;

import homeworks.newSeabattle.data.enums.Messages;
import homeworks.newSeabattle.data.players.Player;
import homeworks.utility.helper.Helper;
import lombok.SneakyThrows;

import java.awt.*;

import static homeworks.newSeabattle.data.enums.Messages.CHOOSE_PLAYERS;

public class IO {

    @SneakyThrows
    public static String getNameFromUser() {
        String message = Messages.NAME.toString();
        return Helper.getString(message);
    }

    @SneakyThrows
    public static boolean getManualFieldCreationFromUser() {
        String message = Messages.MANUAL_CREATION.toString();
        return Helper.getString(message).equalsIgnoreCase("yes");
    }

    @SneakyThrows
    public static int getGameType() {
       String message = CHOOSE_PLAYERS.toString();
       return  Helper.getInt(message);
    }

    @SneakyThrows
    public static Point getUserShoot() {
        String input = Helper.getString("Input (a1 format): ");
        int x = Integer.parseInt(input.substring(1)) - 1;
        int y = convertStringToInt(input.substring(0, 1));
        return new Point(x, y);
    }

    private static int convertStringToInt(String yString) {
        char charY = yString.toUpperCase().charAt(0);
        int y = charY - 65;
        return between0_9(y);
    }

    private static int between0_9(int y) {
        if (0 <= y && y <= 9) {
            return y;
        } else {
            throw new RuntimeException();
        }
    }

    //PRINT_FIELD_METHODS/////////
    public static void showField(Player player) {
        char[] chars = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        System.out.println("  1 2 3 4 5 6 7 8 9 10");

        for (int i = 0; i < 10; i++) {
            System.out.print(chars[i] + "|");
            printPlayerLine(player, i);
            System.out.println("");
        }

        System.out.println("---------------------");
    }

    public static void showFields(Player player1, Player player2) {
        if (player2.isActive()) {
            Player temp = player1;
            player1 = player2;
            player2 = temp;
        }

        char[] chars = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        System.out.println("      YOUR FIELD                 ENEMY FIELD     ");
        System.out.println("  1 2 3 4 5 6 7 8 9 10       1 2 3 4 5 6 7 8 9 10");

        for (int i = 0; i < 10; i++) {
            System.out.print(chars[i] + "|");
            printPlayerLine(player1, i);
            System.out.print("     " + chars[i] + "|");
            printEnemyLine(player2, i);
            System.out.println("");
        }

        System.out.println("-------------------------------------------------");
    }

    private static void printEnemyLine(Player player, int lineNumber) {
        char[] line = player.getField()[lineNumber];
        for (char ch : line) {
            if (ch == 'S') {
                System.out.print(" |");
            } else {
                System.out.print(ch + "|");
            }
        }
    }

    private static void printPlayerLine(Player player, int lineNumber) {
        char[] line = player.getField()[lineNumber];
        for (char ch : line) {
            System.out.print(ch + "|");
        }

    }

}
