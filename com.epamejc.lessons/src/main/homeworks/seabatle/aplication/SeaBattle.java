package homeworks.seabatle.aplication;

import homeworks.seabatle.controller.GameController;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SeaBattle implements Runnable {
    @Override
    public void run() {
        GameController controller = new GameController();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(controller.chooseMode(reader));

        System.out.println(controller.nameUsers(reader));

        System.out.println(controller.createGameBoard(reader));

        System.out.println(controller.printBattleField());

        System.out.println(controller.runBattle(reader, 1000));
    }
}
