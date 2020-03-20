package seabattle.java;

import seabattle.java.logic.Engine;

import static seabattle.java.Utils.*;

/**
 * @author Vitaly Bogdanov
 * @version 1.1
 */
public class SeaBattle {

    Engine engine;

    public void run() {
        System.out.println("\n===================================================================");
        System.out.println("  Welcome to Seabattle v1.1 game. Author: Vitaly Bogdanov (C) 2020.");
        System.out.println("===================================================================");
        boolean repeat;
        do {
            engine = new Engine();
            gameplay();
            repeat = repeatGame();
        } while (repeat);
        System.out.println("\n===================================================================");
        System.out.println("                     Bye! Thank for play!");
        System.out.println("===================================================================");


    }

    private void gameplay() {
        int enemy = chooseEnemy();
        int placementMethod = choosePlacementMethod();

        if (enemy == 1 && placementMethod == 1) {
            engine.startPvPWithManualShipPlacement();
        } else if (enemy == 1 && placementMethod == 2) {
            engine.startPvPWithAutoShipPlacement();
        } else if (enemy == 2 && placementMethod == 2) {
            engine.startPvCWithAutoShipPlacement();
        } else if (enemy == 2 && placementMethod == 1) {
            engine.startPvCWithManualShipPlacement();
        }
    }

    private int chooseEnemy() {
        System.out.println("\nChoose enemy: ");
        System.out.println("     1. Human");
        System.out.println("     2. Computer");
        int enemy = scanOption();
        return enemy;
    }

    private int choosePlacementMethod() {
        System.out.println("\nChoose ship placement method: ");
        System.out.println("     1. Manual");
        System.out.println("     2. Auto");
        int placementMethod = scanOption();
        return placementMethod;
    }

    private boolean repeatGame() {
        System.out.println("\nPlay again?");
        System.out.println("     1. Yes");
        System.out.println("     2. No");
        int repeat = scanOption();
        return repeat == 1;
    }

}
