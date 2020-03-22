package seabattle.game;

import seabattle.players.CompPlayer;
import seabattle.players.HumanPlayer;

import java.io.IOException;

class Game {

    public void startGame() throws IOException {
        CompPlayer compPlayer = new CompPlayer();
        compPlayer.setShips();
        HumanPlayer humanPlayer = new HumanPlayer();
        humanPlayer.setShips();
    }
}
