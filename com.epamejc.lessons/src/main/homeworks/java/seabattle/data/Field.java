package homeworks.java.seabattle.data;

import homeworks.java.seabattle.data.enums.GameState;
import homeworks.java.seabattle.data.enums.Ships;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class Field {

    public static final int deckSize = 10;
    private List<Cell> deck;
    private List<Ship> ships;

    public Field() {

        deck = new ArrayList<>();
        for (int i = 1; i <= deckSize; i++) {
            for (int j = 1; j <= deckSize; j++) {
                deck.add(new Cell(i, j));
            }
        }

        ships = new ArrayList<>();
        for (Ships shipType : Ships.values()) {
            fillShipsList(shipType);
        }

    }

    public String printLine(int line, boolean visible) {

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < deckSize; i++) {
            stringBuilder.append(deck.get((line * deckSize + i)).printCell(visible));
            stringBuilder.append("\t");
        }
        return stringBuilder.toString();

    }

    public void arrangeShipsRandom() {

        Cell startPoint = null,
                alignment = null;
        for (Ship ship : ships) {
            boolean shipPlaced = false;
            while (!shipPlaced) {
                startPoint = new Cell(new Random().nextInt(deckSize) + 1,
                        new Random().nextInt(deckSize) + 1);
                alignment = new Random().nextInt(2) == 0 ?
                        new Cell(0, 1)
                        : new Cell(1, 0);

                shipPlaced = arrangeShip(ship, startPoint, alignment);
            }
            ship.setStartPoint(startPoint);
            ship.setAlignment(alignment);
        }

    }

    public GameState hit(Cell hit) {

        GameState status = GameState.MISS;
        Cell cell = deck.get((hit.getCoordX() - 1) * deckSize + hit.getCoordY() - 1);
        cell.setShootable(false);
        if (isCellOccupied(hit)) {
            Ship ship = cell.getShip();
            boolean killed = ship.hit();
            if (killed) {
                status = GameState.DESTROYED;
                this.markArea(ship);
                ships.remove(ship);
            } else {
                status = GameState.HIT;
            }
        }
        if (ships.size() == 0) {
            status = GameState.GAME_OVER;
        }
        return status;

    }

    private void fillShipsList(Ships shipType) {

        for (int i = 0; i < shipType.getCount(); i++) {
            ships.add(new Ship(shipType));
        }

    }

    private void markArea(Ship ship) {

        List<Cell> area = getArea(ship.getType().getLength(), ship.getStartPoint(), ship.getAlignment());
        area.
                forEach(areaCell ->
                        deck.stream()
                        .filter(fieldCell -> fieldCell.equals(areaCell))
                        .findFirst()
                        .ifPresent(cell -> cell.setShootable(false)));

    }

    private boolean arrangeShip(Ship ship, Cell startPoint, Cell alignment) {

        if (startPoint.getCoordX()*alignment.getCoordX()*ship.getType().getLength() > deckSize
                || startPoint.getCoordY()*alignment.getCoordY()*ship.getType().getLength() > deckSize) {
            return false;
        }

        boolean done = false;
        List<Cell> area = getArea(ship.getType().getLength(), startPoint, alignment);
        if (checkShipArrangementPossibility(area)) {
            int coordX, coordY;
            for (int i = 0; i < ship.getType().getLength(); i++) {
                coordX = startPoint.getCoordX() + alignment.getCoordX() * i - 1;
                coordY = startPoint.getCoordY() + alignment.getCoordY() * i - 1;
                deck.get(coordX * deckSize + coordY).setOccupied(true);
                deck.get(coordX * deckSize + coordY).setShip(ship);
            }
            done = true;
        }
        return done;

    }

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

}