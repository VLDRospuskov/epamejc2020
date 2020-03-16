package homeworks.java.seabattle.field.ship;

import homeworks.java.seabattle.field.Coordinatepointer;
import homeworks.java.seabattle.field.Field;
import homeworks.java.seabattle.input.Orientation;

public class Ship {

    private Deck[] decks;
    private DeckNumberCount deckCount;
    private Orientation orientation;
    private Coordinatepointer[] coordinates;

    public Ship() {
        decks = null;
        deckCount = DeckNumberCount.INVALID;
        orientation = Orientation.NONE;
        coordinates = null;
    }

    public Ship(Field field, DeckNumberCount deckCount, Orientation orientation, Coordinatepointer[] coords) {
        this.deckCount = deckCount;
        this.orientation = orientation;
        this.coordinates = coords;
        decks = new Deck[deckCount.getValue()];

        for (int i = 0; i < decks.length; i++) {
            Deck deck = new Deck(coords[i], '#', 'X');
            decks[i] = deck;
            field.addObject(deck);
        }
    }

    public Coordinatepointer[] getCoordinates() {
        return coordinates;
    }

    public Deck[] getDecks() {
        return decks;
    }

    public DeckNumberCount getDeckCount() {
        return deckCount;
    }

    public boolean isValid() {
        return deckCount != DeckNumberCount.INVALID &&
                orientation != Orientation.NONE &&
                coordinates != null;
    }

    public boolean isShipAlive() {
        boolean isAlive = false;

        for (Deck deck : decks) {
            if (deck.isAlive()) {
                isAlive = true;
            }
        }
        return isAlive;
    }

    public static Coordinatepointer[] getCoordsForShip(Field field, DeckNumberCount deckCount, Orientation orientation,
                                                       Coordinatepointer startCoord) {
        Coordinatepointer step = orientation.getDirection();

        boolean isPossibleToPlace = true;

        Coordinatepointer[] coords = new Coordinatepointer[deckCount.getValue()];
        Coordinatepointer position = new Coordinatepointer(startCoord.x, startCoord.y);

        for (int i = 0; i < deckCount.getValue(); i++) {
            isPossibleToPlace = field.isValidCoordinate(position) &&
                    !field.isCollide(position) &&
                    !field.hasNeighbours(position);

            if (!isPossibleToPlace) {
                break;
            }

            coords[i] = new Coordinatepointer(position.x, position.y);

            position.x = position.x + step.x;
            position.y = position.y + step.y;
        }
        if (isPossibleToPlace) {
            return coords;
        }
        return null;
    }

}
