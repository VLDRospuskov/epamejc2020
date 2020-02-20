package seaBattle.logic;

import seaBattle.data.Player;

import java.util.Scanner;

/**
 * @version 0.1
 * @author Andrew Nuzha
 */
public class Application {

    public void run() {
        Player humanPlayer = new Player();
        Player botPlayer = new Player();

        humanPlayer.shipPlacer().placeShipsAutomatically(humanPlayer.shipsOperations().getShips());
        botPlayer.shipPlacer().placeShipsAutomatically(botPlayer.shipsOperations().getShips());

        Scanner scanner = new Scanner(System.in);
        try {
            Battle seaBattle = new Battle(humanPlayer, botPlayer, scanner);
            seaBattle.startBattle();
        } catch (InterruptedException intEx) {
            System.out.println("There is a problem with thread");
        } catch(Exception ex) {
            System.err.println("Something went wrong " + ex.getMessage());
        } finally {
            scanner.close();
        }
    }
}
