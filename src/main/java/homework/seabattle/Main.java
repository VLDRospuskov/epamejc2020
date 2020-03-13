package homework.seabattle;

import homework.seabattle.actors.Player;
import homework.seabattle.actors.User;

import static homework.seabattle.utils.Input.enterPlayerType;

public class Main {

    public static void main(String[] args) {
        Player player1 = new User();
        Player player2 = Player.create(enterPlayerType());

        player1.setOpponent(player2);
        player2.setOpponent(player1);

        player1.createName();
        player2.createName();

        player1.createShipsLocation();
        player2.createShipsLocation();

        player1.startGame();
    }

}
