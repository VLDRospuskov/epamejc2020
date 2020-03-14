package homework.seabattle.actors;

import homework.seabattle.model.CellState;
import homework.seabattle.model.Coordinate;
import homework.seabattle.model.ships.HorizontalShip;
import homework.seabattle.model.ships.Ship;
import homework.seabattle.model.ships.ShipType;
import homework.seabattle.model.ships.VerticalShip;

import java.util.Random;

import static homework.seabattle.config.Config.*;
import static homework.seabattle.config.Strings.COMPUTERS_SHOTS;
import static homework.seabattle.config.Strings.COMPUTER_NEW_SHOT;
import static homework.seabattle.model.ships.ShipType.Type.HORIZONTAL;
import static homework.seabattle.view.Printer.printShootsOnMap;

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
        printShootsOnMap(situation.getOpponentSituation());
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
            while (!situation.getCellState(randomCoordinate).equals(CellState.State.UNCHECKED)) {
                randomCoordinate = getRandomCoordinate();
            }
            return randomCoordinate;
        }
        return findDamagedShipNextCoordinate();
    }

    private Coordinate findDamagedShipNextCoordinate() {
        Ship ship = situation.searchShip(previousDamage);

        if (ship.isValid()) {
            Coordinate firstCoordinate = ship.getFirstCoordinate();
            Coordinate lastCoordinate = ship.getLastCoordinate();
            Coordinate nextCoordinate = null;

            char firstLetter = firstCoordinate.getLetter();
            int firstNumber = firstCoordinate.getNumber();

            if (ship instanceof VerticalShip || ship.getLength() == 1) {
                nextCoordinate = findVerticalShipNextCoordinate(firstLetter, firstNumber, lastCoordinate.getNumber());
            }

            if (nextCoordinate == null && (ship instanceof HorizontalShip || ship.getLength() == 1)) {
                nextCoordinate = findHorizontalShipNextCoordinate(firstNumber, firstLetter, lastCoordinate.getLetter());
            }

            if (nextCoordinate != null) {
                return nextCoordinate;
            }
        }

        throw new IllegalStateException("Damaged ship was not found");
    }

    private Coordinate findHorizontalShipNextCoordinate(int firstNumber, char firstLetter, char lastLetter) {
        Coordinate nextCoordinate = null;
        if (firstLetter > MIN_LETTER) {
            nextCoordinate = getUncheckedCoordinate((char) (firstLetter - 1), firstNumber);
        }

        if (nextCoordinate == null && lastLetter < MAX_LETTER) {
            nextCoordinate = getUncheckedCoordinate((char) (lastLetter + 1), firstNumber);
        }
        return nextCoordinate;
    }

    private Coordinate findVerticalShipNextCoordinate(char firstLetter, int firstNumber, int lastNumber) {
        Coordinate nextCoordinate = null;
        if (firstNumber > MIN_NUMBER) {
            nextCoordinate = getUncheckedCoordinate(firstLetter, firstNumber - 1);
        }

        if (nextCoordinate == null && lastNumber < MAX_NUMBER) {
            nextCoordinate = getUncheckedCoordinate(firstLetter, lastNumber + 1);
        }
        return nextCoordinate;
    }

    private Coordinate getUncheckedCoordinate(char letter, int number) {
        Coordinate coordinate = new Coordinate(letter, number);
        if (situation.getCellState(coordinate).equals(CellState.State.UNCHECKED)) {
            return coordinate;
        }
        return null;
    }

    private ShipType.Type getRandomShipType() {
        Random random = new Random();
        return ShipType.Type.values()[random.nextInt(HORIZONTAL.ordinal() + 1)];
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
