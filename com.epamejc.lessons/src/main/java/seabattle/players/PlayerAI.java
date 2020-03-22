package seabattle.players;

import lombok.Data;
import seabattle.enums.DifficultyAI;
import seabattle.shipPlacement.ShipPlacer;

import java.util.Random;

@Data
public class PlayerAI extends Player {

    public DifficultyAI difficultyAI = DifficultyAI.EASY;

    @Override
    public String getShootingCommand() {
        int row, column;
        do {
            row = new Random().nextInt(10);
            column = new Random().nextInt(10);
        } while (!isStrikeSuccessful(row, column) && !isStrikeMissing(row, column));

        return String.valueOf((char) (97 + column)) + (row + 1);
    }

    @Override
    public void placeShips() {
        setMainField(ShipPlacer.placeShipsRandomly());
    }

}
