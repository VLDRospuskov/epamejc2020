package seabattle.Main;

import lombok.SneakyThrows;
import seabattle.Menus.BattleMenu;
import seabattle.Menus.MenuShipPlacer;
import seabattle.Players.*;
import seabattle.Settings;
import seabattle.ShipsCounter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Game {

    public Player player1;
    public Player player2;
    //MenuMain mainMenu = new MenuMain();

    public Player currentPlayerTurn;
    //public boolean firstPlayerTurn = true;

    public Game() {
        player1 = new Player();
        player2 = new PlayerAI();
        initPlayers();
    }

    public void startGame() {
        runGame();
    }

    public void runGame() {
        currentPlayerTurn = player1; //chooseRandomPlayer(player1, player2);
        player1.placeShips();
        player2.placeShips(); //TODO заменить на MenuShipPlacer.run()
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

    public void applySettings(Settings settings) {
    }

    @SneakyThrows
    public void startGame2() {
        player1.setEnemy(player2);
        player2.setEnemy(player1);
        player1.setName("Alex");
        player2.setName("Kristina");
        System.out.println("HELLO!");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command;
        System.out.println("Shoot, " + currentPlayerTurn.getName() + "!");
        command = reader.readLine();
//        while (!gameOver()) {
//            int aim = Integer.parseInt(command);
////            if (whichPlayerTurn.enemy.field[aim] == 1) {
////                whichPlayerTurn.enemy.field[aim] = 0;
////                whichPlayerTurn.enemy.shipsLeft--;
////                System.out.println("Great shoot!");
////                if (gameOver()) {
////                    System.out.println(whichPlayerTurn.name + " wins!!!");
////                }
////            } else {
////                System.out.println("U missed =(");
////            }
//            whichPlayerTurn = whichPlayerTurn.enemy;
//            System.out.println("Shoot, " + whichPlayerTurn.name + "!");
//            command = reader.readLine();
//        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.startGame2();
    }

    public boolean gameOver() {
        return player1.getShipsCounter().getAliveShips() == 0 || player2.getShipsCounter().getAliveShips() == 0;
    }

}
