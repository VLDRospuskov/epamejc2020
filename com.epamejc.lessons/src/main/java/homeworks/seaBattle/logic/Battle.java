package homeworks.seaBattle.logic;

import homeworks.seaBattle.data.Configuration;
import homeworks.seaBattle.data.Player;
import homeworks.seaBattle.data.enums.SystemMessages;

import java.util.Scanner;

import static homeworks.seaBattle.utils.RandomNumberGenerator.generateRandomCoordinates;

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

    /**
     * Method for setting exit condition {@link Battle#isGameFinished}
     */
    public static void setExitCondition() {
        isGameFinished = true;
    }

    /**
     * Method for processing battle between human player and computer player
     * @throws InterruptedException exception, if there're troubles with thread
     */
    public void startBattle() throws InterruptedException {
        fieldPrinter.printDoubleField(humanPlayer.getField(),botPlayer.getField());

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
                fieldPrinter.printDoubleField(humanPlayer.getField(),botPlayer.getField());
                if (checkFinishGameConditions()) {
                    isGameFinished = true;
                    break;
                }
            }
            while (isBotMove && !isGameFinished) {
                Thread.sleep(2500);
                isBotMove = botShootingUtil.shot(generateRandomCoordinates(Configuration.getFieldSize()));
                fieldPrinter.printDoubleField(humanPlayer.getField(),botPlayer.getField());
                if (checkFinishGameConditions()) {
                    isGameFinished = true;
                    break;
                }
            }
        }
        determineTheWinner();
    }

    /**
     * Method checks the game finish conditions
     * @return true/false if the game have to continue/finish
     */
    private boolean checkFinishGameConditions() {
        return humanPlayer.getShipsCount() == 0 || botPlayer.getShipsCount() == 0;
    }

    /**
     * Method determines the winner of the game
     */
    private void determineTheWinner() {
        if (humanPlayer.getShipsCount() == 0) {
            System.out.println(SystemMessages.botWin.getMessage());
        }
        if (botPlayer.getShipsCount() == 0) {
            System.out.println(SystemMessages.playerWin.getMessage());
        }
    }
}
