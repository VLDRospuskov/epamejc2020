package homeworks.seabatle.aplication;

import homeworks.seabatle.controller.GameController;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SeaBattle implements Runnable {
    @Override
    public void run() {
        GameController controller = new GameController();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //choosing mode
        System.out.println(controller.chooseMode(reader));
        //players choose their names
        System.out.println(controller.nameUsers(reader));
        //generating fields
        System.out.println(controller.createGameBoard(reader));
        //show game fields
        System.out.println(controller.printBattleField());
        //game
        System.out.println(controller.runBattle(reader,1000));
    }
}
