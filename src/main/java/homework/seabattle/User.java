package homework.seabattle;

import java.util.HashMap;
import java.util.Map;

import static homework.seabattle.Input.*;
import static homework.seabattle.Strings.*;

public class User extends Player {

    private final static Map<Integer, String> enterShipMessages;

    static {
        enterShipMessages = new HashMap<>();
        enterShipMessages.put(1, ENTER_ONE_DECK);
        enterShipMessages.put(2, ENTER_TWO_DECKS);
        enterShipMessages.put(3, ENTER_THREE_DECKS);
        enterShipMessages.put(4, ENTER_FOUR_DECKS);
    }

    @Override
    public void createName() {
        System.out.println(INVITATION);
        name = enterPlayerName();
    }

    @Override
    public void createShipsLocation() {
        System.out.println("\n" + name + ENTER_SHIPS);
        super.createShipsLocation();
    }

    @Override
    protected void shoot() {
        System.out.println("\n" + name + YOUR_SHOTS);
        situation.printShootsOnMap();
        System.out.println(name + ENTER_SHOT_COORDINATE);
        notifyShotAnnounce(enterCoordinate());
    }

    @Override
    protected void addShip(int length) {
        boolean isShipAdded = false;
        while (!isShipAdded) {
            System.out.println(enterShipMessages.get(length));
            try {
                shipsField.tryAddShip(enterCoordinate(), enterShipType(), length);
                isShipAdded = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
