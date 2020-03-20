package homeworks.java.seabattle;

import homeworks.java.seabattle.battle.Game;

/**
 * ## Classic sea battle.
 *
 * **Realized:**
 *
 * + Game with Bot is possible.
 * + You can see the log of the whole game.
 * + Player can fill the field by himself or to choose automatic filling.
 * + Bot field  is filled automatically.
 * + There is a free space between ships, they doesn't touch each other.
 * + When player or Bot hits an enemy ship next attacks the one who hit.
 * + If Bot hits the players ship in next step he hits the neighbour point.
 * + Bot doesn't attacks the points around sank ship.
 * + The game ends when all ships on one side are sank.
 *
 * **Remaining problems:**
 *
 * - If Bot hits the neighbour point after first hitting the players ship and new point is empty (Bot misses)
 * he wouldn't try to finish off discovered ship and will return to random attack.
 * - (minor) If player fills his field be his own, the Bot attacks first.
 * - Unreadable code, needs to be refactored.
 */

public class Main {

    public static void main(String[] args) {
        Game game = new Game();

        while (!game.isGameOver()) {
            game.runGameWithBotPlayer();
        }
    }

}
