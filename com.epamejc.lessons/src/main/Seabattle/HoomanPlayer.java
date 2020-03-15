package Seabattle;

import java.io.IOException;

import static Seabattle.OutputFormatter.*;

public final class HoomanPlayer extends AbstractPlayer {

    public HoomanPlayer(UserInput userInput) {
        setName("Unnamed");
        this.userInput = userInput;
    }

    private final UserInput userInput;

    @Override
    public void requestPlayerName() throws IOException {
        String name = userInput.playerName();
        if (!name.isEmpty()) setName(name);
    }

    private boolean placeShip() throws IOException, CancelledByUserException {
        ShipParameters sp = new ShipParameters();

        while (!userInput.shipStartCell(sp)) ;
        boolean rightShipSize = false;
        while (!rightShipSize) {
            rightShipSize = userInput.shipSize(sp);
            if (rightShipSize) {
                rightShipSize = hasVacantSlotForSize(sp.getSize());
            }
        }
        if (sp.getSize() == 1) {
            sp.setDirection(Direction.UP);
        } else
            while (!userInput.shipDirection(sp)) ;

        if (gameField.checkNewShipArea(sp)) {
            gameField.createShip(sp);
            currentShipCountBySize[sp.getSize()]++;
            return true;
        }

        return false;
    }

    @Override
    public void placeAllShips() throws IOException {
        printColored("Расставить корабли за вас?", TextColor.YELLOW);
        if (userInput.yes()) {
            randomPlaceAllShips();
            System.out.println(gameField);
        } else try {
            placeAllShipsManual();
        } catch (CancelledByUserException e) {
            printColored("User changed their mind and stopped", TextColor.YELLOW);
        }
        userInput.pressAnyKeyToContinue();
    }

    private void placeAllShipsManual() throws IOException, CancelledByUserException {
        System.out.println(gameField);
        printColored("Чтобы выйти введите Stop", TextColor.YELLOW);
        while (hasVacantShipSlots()) {
            if (!placeShip()) {
                printColored("Здесь нельзя поставить корабль", TextColor.RED);
                continue;
            }
            System.out.println(gameField);
        }
    }

    @Override
    public void turn() throws IOException, SurrenderedException, WonException {
        printColored("Ход игрока " + getName(), TextColor.YELLOW);
        userInput.pressAnyKeyToContinue();

        do {
            printColored("Чтобы сдаться введите Surrender", OutputFormatter.TextColor.YELLOW);
            printColored("Ваше поле: ", OutputFormatter.TextColor.BLUE);
            System.out.println(gameField);
            System.out.println();
            printColored("Поле врага: ", OutputFormatter.TextColor.BLUE);
            System.out.println(visibleEnemyGameField);
        }
        while (makeShot());

        System.out.println(gameField);
        System.out.println();
        System.out.println(visibleEnemyGameField);
        userInput.pressAnyKeyToContinue();
    }

    @Override
    protected CellCoordinates cellToShot() throws IOException, SurrenderedException {
        CellCoordinates shotCell = new CellCoordinates();
        try {
            while (!userInput.shotCellCoordinates(shotCell)) ;
            return shotCell;
        } catch (SurrenderedException e) {
            e.player = this;
            throw e;
        }
    }
}
