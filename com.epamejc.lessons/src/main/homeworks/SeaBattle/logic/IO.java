package homeworks.SeaBattle.logic;

import homeworks.SeaBattle.data.enums.Chars;
import homeworks.SeaBattle.data.enums.Messages;
import homeworks.SeaBattle.data.players.Player;
import homeworks.utility.helper.Helper;
import lombok.SneakyThrows;

import java.awt.*;

import static homeworks.SeaBattle.data.enums.Messages.*;
import static homeworks.SeaBattle.logic.Util.*;

public class IO {

    public static String getName() {
        String message = NAME.toString();
        return Helper.getString(message);
    }

    public static int getGameType() {
        String message = CHOOSE_PLAYERS.toString();
        int gameType = Helper.getInt(message);

        while (gameType != 1 && gameType != 2) {
            message = ERROR_WHILE_GAME_TYPE_CHOOSING.toString();
            gameType = Helper.getInt(message);
        }

        return gameType;
    }

    public static boolean getShipsGenerationType(String name) {
        String message = Messages.MANUAL_CREATION.toString() + "for " + name + "? ";
        return Helper.getString(message).equals("1");
    }

    @SneakyThrows
    public static Point getUserShoot() {
        String input = Helper.getString(Messages.INPUT_FOR_SHOOTING.toString()).trim();

        if (input.length() < 2) {
            return getUserShoot();
        }

        int y = Helper.parseIntInLoop(input.substring(1)) - 1;
        int x = convertStringToIntForShooting(input.substring(0, 1));

        if (y > 10) {
            return getUserShoot();
        }

        return new Point(x, y);
    }

    @SneakyThrows
    public static void printWaiting() {
        Thread.sleep(500);
        System.out.print("In progress.");
        for (int i = 0; i < 5; i++) {
            Thread.sleep(300);
            System.out.print(".");
        }
        Thread.sleep(500);
        System.out.println("Done!");
        System.out.println("---------------------------------------------------");
        Thread.sleep(500);
    }

    public static void printField(Player player) {
        String[] numbers = {"1 ", "2 ", "3 ", "4 ", "5 ", "6 ", "7 ", "8 ", "9 ", "10"};
        System.out.println("   A B C D E F G H I J");

        for (int i = 0; i < 10; i++) {
            System.out.print(numbers[i] + "|");
            printPlayerLine(player, i);
            System.out.print("\n");
        }

        System.out.println("----------------------");
    }

    public static void printFields(Player player1, Player player2) {
        if (player2.isActive()) {
            Player temp = player1;
            player1 = player2;
            player2 = temp;
        }

        String[] numbers = {"1 ", "2 ", "3 ", "4 ", "5 ", "6 ", "7 ", "8 ", "9 ", "10"};
        System.out.println("         " + player1.getName() + "                      " + player2.getName());
        System.out.println("   A B C D E F G H I J         A B C D E F G H I J");

        for (int i = 0; i < 10; i++) {
            System.out.print(numbers[i] + "|");
            printPlayerLine(player1, i);
            System.out.print("     " + numbers[i] + "|");
            printEnemyLine(player2, i);
            System.out.print("\n");
        }

        System.out.println("---------------------------------------------------");
    }

    private static void printEnemyLine(Player player, int lineNumber) {
        char[] line = player.getField()[lineNumber];
        for (char ch : line) {
            if (ch == Chars.SHIP.getChar()) {
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
