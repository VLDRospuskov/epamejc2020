package homeworks.java.seabattle.data;

import homeworks.java.seabattle.enums.Ships;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class Field {

    private final int deckSize = 10;
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
            ships.add(new Ship(Ships.CRUISER, Ships.CRUISER.getLength()));
        }
        for (int i = 0; i < Ships.DESTROYER.getCount(); i++) {
            ships.add(new Ship(Ships.DESTROYER, Ships.DESTROYER.getLength()));
        }
        for (int i = 0; i < Ships.CORVETTE.getCount(); i++) {
            ships.add(new Ship(Ships.CORVETTE, Ships.CORVETTE.getLength()));
        }
        for (int i = 0; i < Ships.FIGHTER.getCount(); i++) {
            ships.add(new Ship(Ships.FIGHTER, Ships.FIGHTER.getLength()));
        }

    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < deckSize; i++) {
            for (int j = 0; j < deckSize; j++) {
                stringBuilder.append(field.get((i * deckSize + j)));
                stringBuilder.append("\t");
            }
            stringBuilder.append("\n");
        }
        stringBuilder.append("\n");
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
            System.out.println(this.toString());
        }
    }

    private boolean arrangeShip(Ship ship, Cell startPoint, Cell alignment) {

        boolean isPossible = false;

        isPossible = checkShipArrangementPossibility(ship.getType().getLength(), startPoint, alignment);

        if (isPossible) {
            int coordX, coordY;
            for (int i = 0; i < ship.getType().getLength(); i++) {
                coordX = startPoint.getCoordX() + alignment.getCoordX() * i - 1;
                coordY = startPoint.getCoordY() + alignment.getCoordY() * i - 1;
                field.get(coordX * deckSize + coordY).setOccupied(true);
                field.get(coordX * deckSize + coordY).setShip(ship);
            }
        }
        return isPossible;

    }

    private boolean checkShipArrangementPossibility(int length, Cell startPoint, Cell alignment) {

        boolean isPossible = true;
        int coordX = startPoint.getCoordX();
        int coordY = startPoint.getCoordY();
        int vertical = alignment.getCoordY();
        int horizontal = alignment.getCoordX();

        if ((coordX + length) * horizontal > deckSize || (coordY + length) * vertical > deckSize) {
            return false;
        }

        for (int i = coordX * horizontal + coordY * vertical - 1;
             i < coordX * horizontal + coordY * vertical + length + 1; i++) {

            Cell centre = new Cell(i * horizontal + coordX * vertical,
                    i * vertical + coordY * horizontal);
            Cell bottom = new Cell(i * horizontal + coordX * vertical - vertical,
                    i * vertical + coordY * horizontal - horizontal);
            Cell top = new Cell(i * horizontal + coordX * vertical + vertical,
                    i * vertical + coordY * horizontal + horizontal);

            if (isCellOccupied(centre) || isCellOccupied(bottom) || isCellOccupied(top)) {
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