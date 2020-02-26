package homeworks.seabattle_2_players;

import homeworks.utility.helper.Helper;
import lombok.SneakyThrows;

import java.awt.*;

public class Player {

    public static final int TOTAL_SCORE = 20;
    private int score = 0;
    private boolean isPlayer;
    private boolean isAutomaticCreation;
    private String name;
    private Field playerField;
    private Field enemyField;

    public void turn() {
        Point p;

        if (isPlayer) {
            showFields();
            p = getUserShoot();
        } else {
            p = generateRandomShoot();
        }

        boolean hit = enemyField.shoot(p);
        if (hit) {
            this.score++;
        }
    }

    private Point generateRandomShoot() {
        int x = (int) (Math.random() * 10);
        int y = (int) (Math.random() * 10);
        return new Point(x, y);
    }

    //CONSTRUCTOR///////////
    public Player(String name) {
        this.name = name;
        this.getUserInput();
        this.createField();
    }

    //GETTERS_SETTERS/////////
    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public boolean isPlayer() {
        return isPlayer;
    }

    public boolean isAutomaticCreation() {
        return isAutomaticCreation;
    }

    public void createField() {
        playerField = new Field(isAutomaticCreation);
    }

    public Field getPlayerField() {
        return playerField;
    }

    public void setEnemyField(Field enemyField) {
        this.enemyField = enemyField;
    }

    //PRINT_FIELD_METHODS/////////
    public void showField() {
        char[] chars = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        System.out.println("  1 2 3 4 5 6 7 8 9 10");

        for (int i = 0; i < 10; i++) {
            System.out.print(chars[i] + "|");
            printPlayerLine(i);
            System.out.println("");
        }

        System.out.println("---------------------");
    }

    public void showFields() {
        char[] chars = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        System.out.println("      YOUR FIELD                 ENEMY FIELD     ");
        System.out.println("  1 2 3 4 5 6 7 8 9 10       1 2 3 4 5 6 7 8 9 10");

        for (int i = 0; i < 10; i++) {
            System.out.print(chars[i] + "|");
            printPlayerLine(i);
            System.out.print("     " + chars[i] + "|");
            printEnemyLine(i);
            System.out.println("");
        }

        System.out.println("-------------------------------------------------");
    }

    private void printEnemyLine(int lineNumber) {
        char[] line = enemyField.getCells()[lineNumber];
        for (char ch : line) {
            if (ch == 'S') {
                System.out.print(" |");
            } else {
                System.out.print(ch + "|");
            }
        }
    }

    private void printPlayerLine(int lineNumber) {
        char[] line = playerField.getCells()[lineNumber];
        for (char ch : line) {
            System.out.print(ch + "|");
        }

    }

    //INPUT METHODS/////////////
    public void getUserInput() {
        isPlayer = getWhoFromUser();
        isAutomaticCreation = getHowCreateFromUser();
    }

    @SneakyThrows
    private boolean getWhoFromUser() {
        return Helper.getString("This player is a player(1) or a computer(2)?  ").equals("1");
    }

    @SneakyThrows
    private boolean getHowCreateFromUser() {
        return !isPlayer || Helper.getString("Put ships automatically(1) or manually(2)?  ").equals("1");
    }

    @SneakyThrows
    private Point getUserShoot() {
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
