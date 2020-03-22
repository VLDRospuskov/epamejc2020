package seabattle.main;

import seabattle.shipsCounter.ShipsCounter;
import seabattle.menus.BattleMenu;
import seabattle.players.Player;
import seabattle.players.PlayerAI;
import seabattle.settings.Settings;

import java.util.Random;

public class Game {

    public Player player1;
    public Player player2;

    public Player currentPlayerTurn;

    public Game() {
        player1 = new Player();
        player2 = new PlayerAI();
        initPlayers();
    }

    public void startGame() {
        runGame();
    }

    public void runGame() {
        currentPlayerTurn = chooseRandomPlayer(player1, player2);
        player1.placeShips();
        player2.placeShips();
        new BattleMenu().run();
    }

    public Player chooseRandomPlayer(Player player1, Player player2) {
        return new Random().nextInt(2) == 0 ? player1 : player2;
    }

    public void initPlayers() {
        player1.setEnemy(player2);
        player2.setEnemy(player1);
        player1.setName("Player1");
        player2.setName("Player2");
        player1.setShipsCounter(new ShipsCounter(Settings.maximumNumberOfShipDecks));
        player2.setShipsCounter(new ShipsCounter(Settings.maximumNumberOfShipDecks));
    }

    public boolean gameOver() {
        return player1.getShipsCounter().getAliveShips() == 0 || player2.getShipsCounter().getAliveShips() == 0;
    }

}
