package seaBattle.logic;

import seaBattle.data.Configuration;
import seaBattle.data.Player;

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

    public Battle(Player humanPlayer, Player botPlayer) {
        this.humanPlayer = humanPlayer;
        this.botPlayer = botPlayer;
        this.inputOperator = new InputOperator();
        this.playerShootingUtil = new PlayerShootingUtil(botPlayer);
        this.botShootingUtil = new BotShootingUtil(humanPlayer);
        this.fieldPrinter = new FieldPrinter();
    }

    public static void setExitCondition() {
        isGameFinished = true;
    }

    public void startBattle() {
        try (Scanner scanner = new Scanner(System.in)){
            while (!isGameFinished) {
                int[] shotCoordinates = inputOperator.enterIndexes(scanner, botPlayer, playerShootingUtil);
                playerShootingUtil.shot(shotCoordinates);
                fieldPrinter.printField(humanPlayer.getField(),botPlayer.getField());
                botShootingUtil.shot(generateRandomCoordinates(Configuration.getFieldSize()));
                fieldPrinter.printField(humanPlayer.getField(),botPlayer.getField());
            }
        }
    }

//    private boolean checkWinConditions() {
//        if (humanPlayer.getShipsCount() == 0) {
//            System.out.println("");
//            return true;
//        }
//    }




}
