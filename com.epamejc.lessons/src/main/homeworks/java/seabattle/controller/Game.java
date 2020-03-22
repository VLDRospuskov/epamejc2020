package main.homeworks.java.seabattle.controller;

import main.homeworks.java.seabattle.model.AIPlayer;
import main.homeworks.java.seabattle.model.Player;

import java.util.Scanner;

public class Game {

    public void start(Scanner sc) {
        System.out.println("multiplayer or singleplayer: ");
        String mode = sc.nextLine();
        switch (mode) {
            case "multiplayer":
                startGame(new Player(sc), new Player(sc));
                break;
            case "singleplayer":
                startGame(new Player(sc), new AIPlayer());
                break;
            default:
                System.out.println("invalid command");
                break;
        }
    }

    private void startGame(Player p1, Player p2) {
        p1.setUp();
        p2.setUp();
        while (!gameOver(p1, p2)) {
            p1.shoot(p2);
            p2.shoot(p1);
        }
    }


    private boolean gameOver(Player p1, Player p2) {
        if (p1.getBoard().getFleet().isEmpty() || p2.getBoard().getFleet().isEmpty()) {
            System.out.println("Game over! Final score:");
            System.out.println(p1 + " : " + (10 - p2.getFleet().size()) + " ships destroyed");
            System.out.println(p2 + " : " + (10 - p1.getFleet().size()) + " ships destroyed");
            return true;
        }
        return false;
    }
}
