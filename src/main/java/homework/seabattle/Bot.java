package homework.seabattle;

import java.util.Random;

import static homework.seabattle.Config.*;
import static homework.seabattle.Ship.Type.HORIZONTAL;
import static homework.seabattle.Strings.COMPUTERS_SHOTS;
import static homework.seabattle.Strings.COMPUTER_NEW_SHOT;

public class Bot extends Player {

    private Coordinate previousDamage;

    @Override
    public void createName() {
        name = "Computer";
    }

    @Override
    protected void addShip(int length) {
        boolean isShipAdded = false;
        while (!isShipAdded) {
            try {
                shipsField.tryAddShip(getRandomCoordinate(), getRandomShipType(), length);
                isShipAdded = true;
            } catch (IllegalArgumentException ignored) {
            }
        }
    }

    @Override
    protected void shoot() {
        System.out.println("\n" + COMPUTERS_SHOTS);
        situation.printShootsOnMap();
        Coordinate coordinate = defineNextShot();
        System.out.println(COMPUTER_NEW_SHOT + coordinate.toString());
        notifyShotAnnounce(coordinate);
    }

    @Override
    public void onShipDamaged(Coordinate coordinate) {
        previousDamage = coordinate;
        super.onShipDamaged(coordinate);
    }

    @Override
    public void onShipKilled(Coordinate lastCoordinate) {
        previousDamage = null;
        super.onShipKilled(lastCoordinate);
    }

    private Coordinate defineNextShot() {
        if (previousDamage == null) {
            Coordinate randomCoordinate = getRandomCoordinate();
            while (!situation.getCellState(randomCoordinate).equals(TacticalSituation.CellState.UNCHECKED)) {
                randomCoordinate = getRandomCoordinate();
            }
            return randomCoordinate;
        }
        return searchDamagedShipCoordinate();
    }

    private Coordinate searchDamagedShipCoordinate() {
        Ship ship = situation.searchShip(previousDamage);

        if (ship.isValid()) {
            Coordinate firstCoordinate = ship.getFirstCoordinate();
            Coordinate lastCoordinate = ship.getLastCoordinate();

            if (ship instanceof VerticalShip || ship.getLength() == 1) {
                char letter = firstCoordinate.getLetter();
                int firstNumber = firstCoordinate.getNumber();
                int lastNumber = lastCoordinate.getNumber();

                if (firstNumber > MIN_NUMBER) {
                    Coordinate coordinate = new Coordinate(letter, firstNumber - 1);
                    if (situation.getCellState(coordinate).equals(TacticalSituation.CellState.UNCHECKED))
                        return coordinate;
                }

                if (lastNumber < MAX_NUMBER) {
                    Coordinate coordinate = new Coordinate(letter, lastNumber + 1);
                    if (situation.getCellState(coordinate).equals(TacticalSituation.CellState.UNCHECKED)) {
                        return coordinate;
                    }
                }
            }
            if (ship instanceof HorizontalShip || ship.getLength() == 1) {
                char firstLetter = firstCoordinate.getLetter();
                char lastLetter = lastCoordinate.getLetter();
                int number = firstCoordinate.getNumber();

                if (firstLetter > MIN_LETTER) {
                    Coordinate coordinate = new Coordinate((char) (firstLetter - 1), number);
                    if (situation.getCellState(coordinate).equals(TacticalSituation.CellState.UNCHECKED)) {
                        return coordinate;
                    }
                }

                if (lastLetter < MAX_LETTER) {
                    Coordinate coordinate = new Coordinate((char) (lastLetter + 1), number);
                    if (situation.getCellState(coordinate).equals(TacticalSituation.CellState.UNCHECKED)) {
                        return coordinate;
                    }
                }
            }
        }
        throw new IllegalStateException("Damaged ship was not found");
    }

    private Ship.Type getRandomShipType() {
        Random random = new Random();
        return Ship.Type.values()[random.nextInt(HORIZONTAL.ordinal() + 1)];
    }

    private Coordinate getRandomCoordinate() {
        return new Coordinate(getRandomChar(), getRandomNumber());
    }

    private char getRandomChar() {
        Random random = new Random();
        return (char) (MIN_LETTER + random.nextInt(MAX_LETTER + 1 - MIN_LETTER));
    }

    private int getRandomNumber() {
        Random random = new Random();
        return MIN_NUMBER + random.nextInt(MAX_NUMBER + 1 - MIN_NUMBER);
    }
}
