package homework.seabattle;

import static homework.seabattle.Input.enterPlayerType;
import static homework.seabattle.Strings.YOUR_SHIPS;

public class Game {

    private Player player1;
    private Player player2;

    public static void main(String[] args) {
        Game game = new Game();
        game.init();
        game.start();
    }

    public void init() {
        player1 = new User();
        player2 = Player.create(enterPlayerType());

        player1.setOpponent(player2);
        player2.setOpponent(player1);

        player1.createName();
        player2.createName();

//        Debug.setShipsLocation1(player1.getShipsField());
//        System.out.println("\n" + player1.name + YOUR_SHIPS);
//        player1.getShipsField().printShipsOnMap();

        player1.createShipsLocation();
        player2.createShipsLocation();
    }

    public void start() {
        player1.startGame();
    }
}
