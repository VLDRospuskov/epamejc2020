package homework.seabattle;

import java.util.Scanner;

import static homework.seabattle.Config.*;
import static homework.seabattle.Input.*;
import static homework.seabattle.Strings.*;

public class Game {

    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public static void main(String[] args) {
        Game game = new Game();
        game.init();
        game.start();
    }

    public void init() {
        player1 = new Player();
        player2 = new Player();

        player1.setOpponent(player2);
        player2.setOpponent(player1);

        askPlayersName();
        Debug.setShipsLocation1(player1.getShipsField());
        Debug.setShipsLocation2(player2.getShipsField());

//        askShipsLocation(player1);
//        askShipsLocation(player2);

        System.out.println(player1.getName());
        Debug.printMap(player1.getShipsField().getOwnActiveShips());
        System.out.println(player2.getName());
        Debug.printMap(player2.getShipsField().getOwnActiveShips());
    }

    public void start() {
        TacticalSituation situation1 = player1.getSituation();
        TacticalSituation situation2 = player2.getSituation();

        while (true) {
            System.out.println(player1.getName() + ENTER_SHOT_COORDINATE);
            player1.shoot(enterCoordinate());
            if (situation1.getOpponentActiveShipsCount() == 0) {
                System.out.println(player1.getName() + WIN);
                break;
            }

            System.out.println(player2.getName() + ENTER_SHOT_COORDINATE);
            player2.shoot(enterCoordinate());
            if (situation2.getOpponentActiveShipsCount() == 0) {
                System.out.println(player2.getName() + WIN);
                break;
            }
        }
    }

    private void askPlayersName() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(PLAYER1 + INVITATION);
        player1.setName(scanner.nextLine());

        System.out.println(PLAYER2 + INVITATION);
        player2.setName(scanner.nextLine());
    }

    private void askShipsLocation(Player player) {
        System.out.println(player.getName() + ENTER_SHIPS);
        ShipsField shipsField = player.getShipsField();

        enterShip(shipsField, 4);

        for (int i = 0; i < THREEDECKS_SHIPS_COUNT; i++) {
            enterShip(shipsField, 3);
        }

        for (int i = 0; i < TWODECKS_SHIPS_COUNT; i++) {
            enterShip(shipsField, 2);
        }

        for (int i = 0; i < ONEDECK_SHIPS_COUNT; i++) {
            enterShip(shipsField, 1);
        }
    }
}
