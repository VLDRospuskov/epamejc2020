package seaBattle.logic;

import seaBattle.data.Configuration;
import seaBattle.data.Player;
import seaBattle.data.enums.SystemMessages;

import java.util.Scanner;

import static seaBattle.utils.RandomNumberGenerator.generateRandomCoordinates;

public class Battle {

    private Player humanPlayer;
    private Player botPlayer;
    private InputOperator inputOperator;
    private static boolean isGameFinished = false;
    private PlayerShootingUtil playerShootingUtil;
    private BotShootingUtil botShootingUtil;
    private FieldPrinter fieldPrinter;
    private Scanner scanner;

    public Battle(Player humanPlayer, Player botPlayer, Scanner scanner) {
        this.humanPlayer = humanPlayer;
        this.botPlayer = botPlayer;
        this.inputOperator = new InputOperator();
        this.playerShootingUtil = new PlayerShootingUtil(botPlayer);
        this.botShootingUtil = new BotShootingUtil(humanPlayer);
        this.fieldPrinter = new FieldPrinter();
        this.scanner = scanner;
    }

    public static void setExitCondition() {
        isGameFinished = true;
    }

    public void startBattle() throws InterruptedException {
        fieldPrinter.printField(humanPlayer.getField(),botPlayer.getField());

        while (!isGameFinished) {
            boolean isPlayerMove = true;
            boolean isBotMove = true;

            while (isPlayerMove && !isGameFinished) {
                botPlayer.shipsOperations().printShipsNumber();
                int[] shotCoordinates = inputOperator.enterIndexes(scanner, botPlayer, playerShootingUtil);
                if (isGameFinished) {
                    break;
                }
                isPlayerMove = playerShootingUtil.shot(shotCoordinates);
                fieldPrinter.printField(humanPlayer.getField(),botPlayer.getField());
//                botPlayer.shipsOperations().printShipsNumber();
                if (checkFinishGameConditions()) {
                    isGameFinished = true;
                    break;
                }
            }
            while (isBotMove && !isGameFinished) {
                Thread.sleep(2500);
                isBotMove = botShootingUtil.shot(generateRandomCoordinates(Configuration.getFieldSize()));
                fieldPrinter.printField(humanPlayer.getField(),botPlayer.getField());
                if (checkFinishGameConditions()) {
                    isGameFinished = true;
                    break;
                }
            }
        }
        determineTheWinner();
    }

    private boolean checkFinishGameConditions() {
        return humanPlayer.getShipsCount() == 0 || botPlayer.getShipsCount() == 0;
    }

    private void determineTheWinner() {
        if (humanPlayer.getShipsCount() == 0) {
            System.out.println(SystemMessages.botWin.getMessage());
        }
        if (botPlayer.getShipsCount() == 0) {
            System.out.println(SystemMessages.playerWin.getMessage());
        }
    }
}
