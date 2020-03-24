package homework.Seabattle;

import java.io.IOException;

public interface Player {
    class WonException extends Exception {
        final Player player;
        WonException(Player player) {
            this.player = player;
        }
    }

    String getName();
    void setEnemy(Player enemy);

    void requestPlayerName() throws IOException;
    void placeAllShips() throws IOException;
    void turn() throws IOException, SurrenderedException, WonException;

    boolean hasShips();
    boolean hasShipAt(CellCoordinates cellCoordinates);

    void hitShipAt(CellCoordinates cellCoordinates);
    void setMissAt(CellCoordinates cellCoordinates);
    boolean checkShipDestroyed(CellCoordinates shipCell);
    void printGameField();
}
