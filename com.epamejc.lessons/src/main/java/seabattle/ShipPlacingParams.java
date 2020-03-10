package seabattle;

import lombok.AllArgsConstructor;
import lombok.Data;
import seabattle.Enums.Direction;

@Data
@AllArgsConstructor
public class ShipPlacingParams {

    private int row;
    private int column;
    private int numberOfDecks;
    private Direction direction;

    public ShipPlacingParams(String rawStringOfParams, int decks) {
        String[] coordinatesAndDirection = rawStringOfParams.split(" ");
        row = Integer.parseInt(coordinatesAndDirection[0].substring(1)) - 1;
        column = coordinatesAndDirection[0].charAt(0) - 97;
        direction = coordinatesAndDirection.length > 1 ? Direction.parseDirectionFromString(coordinatesAndDirection[1]) : Direction.RIGHT;
        numberOfDecks = decks;
    }

}
