package homeworks.java.seabattle.data;

import homeworks.java.seabattle.data.enums.GameState;
import homeworks.java.seabattle.engine.GameIO;
import homeworks.java.seabattle.engine.Settings;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class Field {

    private int DECK_SIZE;
    private List<Cell> deck;
    private List<Ship> ships;
    private Settings settings;

    public Field() {

        settings = new Settings();
        DECK_SIZE = settings.getDeckSize();
        deck = new ArrayList<>();
        ships = new ArrayList<>();
        setupNewField();

    }

    public String printLine(int line, boolean visible) {

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < DECK_SIZE; i++) {
            stringBuilder.append(deck.get((line * DECK_SIZE + i)).printCell(visible));
            stringBuilder.append("\t");
        }
        return stringBuilder.toString();

    }

    public void arrangeShipsRandom() {

        setupNewField();
        for (Ship ship : ships) {
            boolean shipPlaced = false;
            while (!shipPlaced) {
                Cell startPoint = new Cell(new Random().nextInt(DECK_SIZE) + 1,
                        new Random().nextInt(DECK_SIZE) + 1);
                ship.setStartPoint(startPoint);
                Cell alignment = new Random().nextInt(2) == 0 ?
                        new Cell(0, 1)
                        : new Cell(1, 0);
                ship.setAlignment(alignment);
                shipPlaced = arrangeShip(ship, startPoint, alignment);
            }
        }

    }

    public GameState hit(Cell hit) {

        return deck.stream()
                .filter(found -> found.equals(hit))
                .filter(Cell::isShootable)
                .peek(found -> found.setShootable(false))
                .filter(Cell::isOccupied)
                .map(Cell::getShip)
                .map(this::getState)
                .findFirst()
                .orElse(GameState.MISS);

    }

    private void setupNewField() {

        deck = new ArrayList<>();
        fillDeck();
        ships = settings.getShipsList();

    }

    private void fillDeck() {

        for (int i = 1; i <= DECK_SIZE; i++) {
            for (int j = 1; j <= DECK_SIZE; j++) {
                deck.add(new Cell(i, j));
            }
        }

    }

    /**
     * Marks the area around destroyed ship as already hit.
     *
     * @param ship destroyed ship.
     */
    private void markArea(Ship ship) {

        List<Cell> area = getArea(ship.getSize(), ship.getStartPoint(), ship.getAlignment());
        area.
                forEach(areaCell ->
                        deck.stream()
                                .filter(fieldCell -> fieldCell.equals(areaCell))
                                .findFirst()
                                .ifPresent(cell -> cell.setShootable(false)));

    }

    private boolean arrangeShip(Ship ship, Cell startPoint, Cell alignment) {

        if (isOutOfBorders(ship, startPoint, alignment)) {
            return false;
        }
        boolean done = false;
        List<Cell> area = getArea(ship.getSize(), startPoint, alignment);
        if (checkShipArrangementPossibility(area)) {
            int coordX, coordY;
            for (int i = 0; i < ship.getSize(); i++) {
                coordX = startPoint.getCoordX() + alignment.getCoordX() * i - 1;
                coordY = startPoint.getCoordY() + alignment.getCoordY() * i - 1;
                deck.get(coordX * DECK_SIZE + coordY).setOccupied(true);
                deck.get(coordX * DECK_SIZE + coordY).setShip(ship);
            }
            done = true;
        }
        return done;

    }

    private boolean isOutOfBorders(Ship ship, Cell startPoint, Cell alignment) {

        return startPoint.getCoordX() * alignment.getCoordX() * ship.getSize() > DECK_SIZE
                || startPoint.getCoordY() * alignment.getCoordY() * ship.getSize() > DECK_SIZE;

    }

    /**
     * Calculates the coordinates of the cells around the ship.
     *
     * @param length     of the ship
     * @param startPoint the first deck of the ship
     * @param alignment  the {@link Cell} with [0, 1] or [1, 0] as coordinates used to
     *                   represent ships alignment in the calculations.
     * @return {@code List} of cells around the ship.
     */
    private List<Cell> getArea(int length, Cell startPoint, Cell alignment) {

        List<Cell> area = new ArrayList<>();
        int coordX = startPoint.getCoordX();
        int coordY = startPoint.getCoordY();
        int vertical = alignment.getCoordY();
        int horizontal = alignment.getCoordX();

        for (int i = coordX * horizontal + coordY * vertical - 1;
             i < coordX * horizontal + coordY * vertical + length + 1; i++) {
            area.add(new Cell(i * horizontal + coordX * vertical,
                    i * vertical + coordY * horizontal));
            area.add(new Cell(i * horizontal + coordX * vertical - vertical,
                    i * vertical + coordY * horizontal - horizontal));
            area.add(new Cell(i * horizontal + coordX * vertical + vertical,
                    i * vertical + coordY * horizontal + horizontal));
        }
        return area;

    }

    private boolean checkShipArrangementPossibility(List<Cell> area) {

        return area.stream()
                .noneMatch(this::isCellOccupied);

    }

    private boolean isCellOccupied(Cell cell) {

        return deck.stream()
                .filter(actual -> actual.equals(cell))
                .findFirst()
                .map(Cell::isOccupied)
                .orElse(false);

    }

    /**
     * Checks if the ship is destroyed or game is over.
     * If ship is destroyed calls {@link #markArea(Ship)} method.
     *
     * @return {@link GameState}
     */
    private GameState getState(Ship ship) {

        GameState state = ship.hit();
        if (state.equals(GameState.DESTROYED)) {
            markArea(ship);
            ships.remove(ship);
            if (ships.size() == 0) {
                return GameState.GAME_OVER;
            }
        }
        return state;
    }

}