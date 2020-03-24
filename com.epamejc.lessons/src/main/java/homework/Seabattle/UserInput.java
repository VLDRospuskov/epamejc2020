package homework.Seabattle;

import java.io.BufferedReader;
import java.io.IOException;

import static homework.Seabattle.OutputFormatter.*;

class CancelledByUserException extends Exception {
}

class SurrenderedException extends Exception {
    Player player;
}

class UserInput {
    private final String cancelCommand = "Stop";
    private final String surrenderCommand = "Surrender";
    private BufferedReader reader;

    UserInput(BufferedReader reader) {
        this.reader = reader;
    }

    String playerName() throws IOException {
        printColored("Введите имя игрока", TextColor.YELLOW);
        return reader.readLine();
    }

    boolean yes() throws IOException {
        printColored("Введите Yes или No: ", TextColor.YELLOW);
        return reader.readLine().equalsIgnoreCase("yes");
    }

    boolean shipStartCell(ShipParameters sp) throws IOException, CancelledByUserException {
        CellCoordinates cc = new CellCoordinates();
        printColored("Введите координату начала корабля в формате буква (a-j) + число (1-10), например, 'a1': ",
                TextColor.BLUE);
        String startCellS = reader.readLine();

        if (startCellS.equalsIgnoreCase(cancelCommand)) throw new CancelledByUserException();

        if (!cellCoordinates(startCellS, cc)) return false;

        sp.setStartCell(cc);
        return true;
    }

    boolean shipSize(ShipParameters sp) throws IOException, CancelledByUserException {
        printColored("Введите размер корабля в пределах [1, 4]: ", TextColor.BLUE);
        String sizeS = reader.readLine();

        if (sizeS.equalsIgnoreCase(cancelCommand)) throw new CancelledByUserException();

        int size;
        try {
            size = Integer.parseInt(sizeS);
        } catch (NumberFormatException e) {
            printColored(String.format("Неверное число (%s). Ожидалось число от 1 до 4.", sizeS), TextColor.RED);
            return false;
        }
        if (size >= 1 && size <= 4) {
            sp.setSize(size);
            return true;
        }
        return false;
    }

    boolean gameDifficulty(Game game) throws IOException {
        String gameDiffs = reader.readLine().toUpperCase();
        switch (gameDiffs) {
            case "EASY":
                game.setDifficulty(Game.Difficulty.EASYPEASY);
                break;
            case "NORMAL":
                game.setDifficulty(Game.Difficulty.NORMAL);
                break;
            case "HARD":
                game.setDifficulty(Game.Difficulty.HARD);
                break;
            default:
                printColored(String.format("Неверный ввод (%s). Ожидалось одно из значений [easy, normal, hard]"
                        , gameDiffs), TextColor.RED);
                return false;
        }
        return true;
    }

    boolean shipDirection(ShipParameters sp) throws IOException, CancelledByUserException {
        printColored("Введите направление корабля (одну букву) [DOWN (d), UP (u), RIGHT (r), LEFT (l)]: ", TextColor.BLUE);
        String directionS = reader.readLine().toUpperCase();

        if (directionS.equalsIgnoreCase(cancelCommand)) throw new CancelledByUserException();

        switch (directionS) {
            case "L":
                sp.setDirection(Direction.LEFT);
                break;
            case "R":
                sp.setDirection(Direction.RIGHT);
                break;
            case "U":
                sp.setDirection(Direction.UP);
                break;
            case "D":
                sp.setDirection(Direction.DOWN);
                break;
            default:
                printColored(String.format("Неверный ввод (%s). Ожидалось одно из значений [d, u, r, l]"
                        , directionS), TextColor.RED);
                return false;
        }
        return true;
    }

    boolean shotCellCoordinates(CellCoordinates cc) throws IOException, SurrenderedException {
        printColored("Введите координату выстрела в формате буква (a-j) + число (1-10), например, 'a1': "
                , TextColor.BLUE);
        String shotCellS = reader.readLine();

        if (shotCellS.equalsIgnoreCase(surrenderCommand)) throw new SurrenderedException();

        return cellCoordinates(shotCellS, cc);
    }

    private boolean cellCoordinates(String startCellS, CellCoordinates cc) {
        try {
            CellCoordinates cellCoordinates = CellCoordinates.fromString(startCellS);
            cc.setCharacter(cellCoordinates.getCharacter());
            cc.setInteger(cellCoordinates.getInteger());
        } catch (CellCoordinates.WrongCellLetterException e) {
            printColored("Вы ввели неправильную букву", OutputFormatter.TextColor.RED);
            return false;
        } catch (CellCoordinates.WrongCellNumberException e) {
            printColored("Вы неправильно ввели число", OutputFormatter.TextColor.RED);
            return false;
        }

        return true;
    }

    void pressAnyKeyToContinue() throws IOException {
        printColored("Нажмите Enter чтобы продолжить...", TextColor.YELLOW);
        reader.readLine();
    }
}

