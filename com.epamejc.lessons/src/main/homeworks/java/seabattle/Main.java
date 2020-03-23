package homeworks.java.seabattle;

import homeworks.java.seabattle.engine.SeaBattle;
import homeworks.java.utils.UserInputReader;

/**
 * This is a classic Sea Battle game.
 * Two players can play it against each other or one player against bot or two bots against each other.
 * <p>
 * Sea Battle is a strategy type guessing game for two players. It is played on ruled grids on which each player's
 * fleet of ships are marked. The locations of the fleets are concealed from the other player. Players alternate
 * turns calling "shots" at the other player's ships, and the objective of the game is to destroy the
 * opposing player's fleet.
 * Each ship is separated from another one with at least one cell in each direction.
 * <p>
 * If player shoots at the already hit cell, the game decides this is a miss.
 * The game ends when one of the players loses all his ships.
 * <p>
 * {@author Vladimir Ivanov}
 */
public class Main {

    public static void main(String[] args) {

        SeaBattle seabattle = new SeaBattle();
        seabattle.run();
        UserInputReader.close();

    }

}
