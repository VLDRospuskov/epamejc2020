package homeworks.java.seabattle.data;

import homeworks.java.seabattle.enums.GameStats;
import homeworks.java.seabattle.enums.Ships;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Getter
public class Field {

    public static final int deckSize = 10;
    private List<Cell> field;
    private List<Ship> ships;

    public Field() {

        field = new ArrayList<>();
        for (int i = 1; i <= deckSize; i++) {
            for (int j = 1; j <= deckSize; j++) {
                field.add(new Cell(i, j));
            }
        }

        ships = new ArrayList<>();
        for (int i = 0; i < Ships.CRUISER.getCount(); i++) {
            ships.add(new Ship(Ships.CRUISER));
        }
        for (int i = 0; i < Ships.DESTROYER.getCount(); i++) {
            ships.add(new Ship(Ships.DESTROYER));
        }
        for (int i = 0; i < Ships.CORVETTE.getCount(); i++) {
            ships.add(new Ship(Ships.CORVETTE));
        }
        for (int i = 0; i < Ships.FIGHTER.getCount(); i++) {
            ships.add(new Ship(Ships.FIGHTER));
        }

    }

    public String printLine(int line) {

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < deckSize; i++) {
            stringBuilder.append(field.get((line * deckSize + i)).printCell());
            stringBuilder.append("\t");
        }
        return stringBuilder.toString();

    }

    public String printHead() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("   ");
        for (int i = 1; i <= deckSize; i++) {
            stringBuilder.append(i);
            stringBuilder.append("\t");
        }
        return stringBuilder.toString();

    }

    public String printPlayerName(String name) {

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < deckSize; i++) {
            if (i == deckSize/2) {
                stringBuilder.append(name);
            }
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

    public GameStats hit(Cell hit) {

        GameStats status = GameStats.MISS;
        if (isCellOccupied(hit)) {
            Cell cell = field.get((hit.getCoordX()-1) * deckSize + hit.getCoordY());
            Ship ship = cell.getShip();
            boolean killed = ship.hit();
            cell.setShootable(false);
            if (killed) {
                status = GameStats.DESTROYED;
                this.markArea(ship);
                ships.remove(ship);
            } else {
                status = GameStats.HIT;
            }
        }
        if (ships.size() == 0) {
            status = GameStats.GAME_OVER;
        }

        return status;

    }

    private void markArea(Ship ship) {

        List<Cell> area = getArea(ship.getType().getLength(), ship.getStartPoint(), ship.getAlignment());

        for (Cell cell : area) {
            field
                    .stream()
                    .filter(found -> found.equals(cell))
                    .findFirst()
                    .ifPresent(actual -> actual.setShootable(false));
        }

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

    private boolean arrangeShip(Ship ship, Cell startPoint, Cell alignment) {

        boolean done = false;

        if (checkShipArrangementPossibility(getArea(ship.getType().getLength(), startPoint, alignment))) {
            int coordX, coordY;
            for (int i = 0; i < ship.getType().getLength(); i++) {
                coordX = startPoint.getCoordX() + alignment.getCoordX() * i - 1;
                coordY = startPoint.getCoordY() + alignment.getCoordY() * i - 1;
                field.get(coordX * deckSize + coordY).setOccupied(true);
                field.get(coordX * deckSize + coordY).setShip(ship);

            }
            done = true;
        }
        return done;

    }

    private boolean checkShipArrangementPossibility(List<Cell> area) {

        if ((area.get(area.size() - 4)).getCoordX() > deckSize
                || (area.get(area.size() - 4)).getCoordY() > deckSize) {
            return false;
        }

        boolean isPossible = true;
        for (Cell cell : area) {
            if (isCellOccupied(cell)) {
                isPossible = false;
                break;
            }
        }
        return isPossible;

    }

    private boolean isCellOccupied(Cell cell) {

        boolean occupied = false;

        Cell temporary = field.stream()
                .filter(actual -> actual.equals(cell))
                .findFirst()
                .orElse(null);

        if (temporary != null) {
            occupied = temporary.isOccupied();
        }
        return occupied;

    }

}