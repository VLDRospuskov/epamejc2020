package seaBattle.logic;

import seaBattle.data.Player;

import java.util.Scanner;

public class Battle {

    private Player humanPlayer;
    private Player botPlayer;
    private InputOperator inputOperator;
    private static boolean isGameFinished = false;

    public Battle(Player humanPlayer, Player botPlayer) {
        this.humanPlayer = humanPlayer;
        this.botPlayer = botPlayer;
        this.inputOperator = new InputOperator();
    }

    public void startBattle() {
        try (Scanner scanner = new Scanner(System.in)){
            while (!isGameFinished) {
                //ввести индекс
                inputOperator.enterIndexes(scanner);
                break;


            }
        }

    }

    public static void setExitCondition() {
        isGameFinished = true;
    }
}
