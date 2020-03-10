package seabattle;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.LinkedHashMap;
import java.util.Map;

@NoArgsConstructor
public class ShipsCounter {
    public Map<Integer, Integer> shipMap = new LinkedHashMap<>();
    //    @Getter
//    private int aliveShipCellsCounter = 0;
    @Getter
    private int aliveShips = 0;

    public ShipsCounter(int maximumNumberOfShipDecks) {
        int numberOfShips = 1;
        for (int numberOfDecks = maximumNumberOfShipDecks; numberOfDecks >= 1; numberOfDecks--) {
            shipMap.put(numberOfDecks, numberOfShips);
            aliveShips += numberOfShips;
            //aliveShipCellsCounter += numberOfDecks * numberOfShips;
            numberOfShips++;
        }
    }

    public void decreaseShipsLeftCounter() {
        aliveShips--;
    }

}
