package Seabattle;

import java.util.*;

public class GameField {
    private final static String forRandomChar = "abcdefghij";
    private static final Random RANDOM = new Random();

    private CellState[][] cellStates = new CellState[10][10];

    {
        for (int i = 0; i < cellStates.length; i++) {
            cellStates[i] = new CellState[10];
            for (int j = 0; j < cellStates[i].length; j++) {
                cellStates[i][j] = CellState.EMPTY;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("   a b c d e f g h i j\n");
        for (int i = 0; i < cellStates.length - 1; i++) {
            sb.append(" ").append((char) ('1' + (char) i)).append('|');
            for (int j = 0; j < cellStates[0].length; j++) {
                sb.append(cellStates[i][j].toString());
            }
            sb.append('\n');
        }
        sb.append("10|");
        for (int i = 0; i < cellStates[cellStates.length - 1].length; i++) {
            sb.append(cellStates[cellStates.length - 1][i].toString());
        }
        return sb.toString();
    }

    public GameField copy() {
        GameField copy = new GameField();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                copy.cellStates[i][j] = cellStates[i][j];
            }
        }

        return copy;
    }

    private void checkCell(char c, int n) {
        if (n < 1 || n > 10) {
            throw new IndexOutOfBoundsException("GameField indices should be in range [1, 10]. Got " + n);
        }
        if (c < 'a' || c > 'j') {
            throw new IndexOutOfBoundsException("GameField indices should be in range [a, j]. Got " + c);
        }
    }

    public void setCell(CellCoordinates cc, CellState cs) {
        setCell(cc.getCharacter(), cc.getInteger(), cs);
    }

    public void setCell(char c, int n, CellState cs) {
        c = Character.toLowerCase(c);
        try {
            checkCell(c, n);
        } catch (IndexOutOfBoundsException e) {
            throw e;
        }
        cellStates[n - 1][c - 'a'] = cs;
    }

    public CellState getCellState(CellCoordinates cc) {
        return getCellState(cc.getCharacter(), cc.getInteger());
    }

    public CellState getCellState(char c, int n) {
        c = Character.toLowerCase(c);
        try {
            checkCell(c, n);
        } catch (IndexOutOfBoundsException e) {
            return CellState.OUT_OF_BOUNDS;
        }
        return cellStates[n - 1][c - 'a'];
    }

    boolean checkCreateShip(ShipParameters sp) {
        return checkCreateShip(
                sp.getStartCell().getCharacter(),
                sp.getStartCell().getInteger(),
                sp.getSize(),
                sp.getDirection());
    }

    boolean checkCreateShip(char c, int n, int size, Direction direction) {
        if (getCellState(c, n) != CellState.EMPTY) return false;
        CellCoordinates c1 = new CellCoordinates();
        CellCoordinates c2 = new CellCoordinates();
        areaToCheck(c, n, size, direction, c1, c2);
        return checkNewShipArea(c1, c2);
    }

    void areaToCheck(ShipParameters sp, CellCoordinates c1, CellCoordinates c2) {
        areaToCheck(sp.getStartCell().getCharacter(),
                sp.getStartCell().getInteger(),
                sp.getSize(),
                sp.getDirection(), c1, c2);
    }

    void areaToCheck(char c, int n, int size, Direction direction, CellCoordinates c1, CellCoordinates c2) {
        switch (direction) {
            case LEFT:
                c1.setInteger(n - 1);
                c1.setCharacter((char) (c - size));
                c2.setInteger(n + 1);
                c2.setCharacter((char) (c + 1));
                break;
            case RIGHT:
                c1.setInteger(n - 1);
                c1.setCharacter((char) (c - 1));
                c2.setInteger(n + 1);
                c2.setCharacter((char) (c + size));
                break;
            case UP:
                c1.setInteger(n - size);
                c1.setCharacter((char) (c - 1));
                c2.setInteger(n + 1);
                c2.setCharacter((char) (c + 1));
                break;
            case DOWN:
                c1.setInteger(n - 1);
                c1.setCharacter((char) (c - 1));
                c2.setInteger(n + size);
                c2.setCharacter((char) (c + 1));
                break;
        }
    }

    boolean checkNewShipArea(ShipParameters sp) {
        return checkNewShipArea(sp.getShipAreaTopLeft(), sp.getShipAreaBottomRight());
    }

    boolean checkNewShipArea(CellCoordinates c1, CellCoordinates c2) {
        Set<CellState> emptyOrOOB = new HashSet<>(Arrays.asList(CellState.MISSED, CellState.EMPTY, CellState.OUT_OF_BOUNDS));
        Set<CellState> empty = new HashSet<>(Collections.singletonList(CellState.EMPTY));

        return checkArea(c1, c2, emptyOrOOB) && checkArea(c1.add((char) 1, 1), c2.subtract((char) 1, 1), empty);
    }

    private boolean checkArea(CellCoordinates c1, CellCoordinates c2, Set<CellState> possibleStates) {
        for (char ch = c1.getCharacter(); ch <= c2.getCharacter(); ch++) {
            for (int i = c1.getInteger(); i <= c2.getInteger(); i++) {
                if (!possibleStates.contains(getCellState(ch, i))) return false;
            }
        }

        return true;
    }

    int checkShipDestroyed(CellCoordinates shotCoordinates) {
        Set<CellCoordinates> ship = getSetOfShipCells(shotCoordinates, true);

        for (CellCoordinates cc: ship){
            if (getCellState(cc) != CellState.SHIP_HIT) return 0;
        }

        return ship.size();
    }

    void setAreaDestroyedShipCellsMissed(CellCoordinates shotCell) {
        CellCoordinates c1 = new CellCoordinates();
        CellCoordinates c2 = new CellCoordinates();
        areaToCheck(shotCell.getCharacter(), shotCell.getInteger(), 1, Direction.UP, c1, c2);
        for (char ch = c1.getCharacter(); ch <= c2.getCharacter(); ch++) {
            for (int i = c1.getInteger(); i <= c2.getInteger(); i++) {
                if (getCellState(ch, i) == CellState.EMPTY)
                    setCell(ch, i, CellState.MISSED);
            }
        }
    }

    static CellCoordinates getRandomCellCoordinates() {
        char randomStartChar = forRandomChar.charAt(RANDOM.nextInt(forRandomChar.length()));
        int randomStartNum = RANDOM.nextInt(10) + 1;
        return new CellCoordinates(randomStartChar, randomStartNum);

    }

    private void fillInShipSet(Set<CellCoordinates> ship, CellCoordinates shipCell, boolean countIntactCells) {
        CellCoordinates c1 = new CellCoordinates();
        CellCoordinates c2 = new CellCoordinates();

        areaToCheck(shipCell.getCharacter(), shipCell.getInteger(), 1, Direction.UP, c1, c2);
        for (char ch = c1.getCharacter(); ch <= c2.getCharacter(); ch++) {
            for (int i = c1.getInteger(); i <= c2.getInteger(); i++) {
                CellState cs = getCellState(ch, i);
                if (cs == CellState.SHIP_HIT || (cs == CellState.SHIP && countIntactCells)) {
                    CellCoordinates newCC = new CellCoordinates(ch, i);
                    if (!ship.contains(newCC)) {
                        ship.add(newCC);
                        fillInShipSet(ship, newCC, countIntactCells);
                    }
                }
            }
        }
    }

    Set<CellCoordinates> getSetOfShipCells(CellCoordinates shipCell, boolean countIntactCells) {
        Set<CellCoordinates> ship = new HashSet<>(Collections.singletonList(shipCell));
        fillInShipSet(ship, shipCell, countIntactCells);

        return ship;
    }

    boolean hasShips() {
        Set<CellState> possibleStates = new HashSet<>(
                Arrays.asList(
                        CellState.OUT_OF_BOUNDS,
                        CellState.EMPTY,
                        CellState.MISSED,
                        CellState.SHIP_HIT));

        return !checkArea(CellCoordinates.topLeft, CellCoordinates.bottomRight, possibleStates);
    }

    void createShip(ShipParameters sp) {
        createShip(sp.getStartCell().getCharacter(), sp.getStartCell().getInteger(), sp.getSize(), sp.getDirection());
    }

    void createShip(char c, int n, int size, Direction direction) {
        setCell(c, n, CellState.SHIP);

        switch (direction) {
            case LEFT:
                for (char i = 1; i < size; i++) setCell((char) (c - i), n, CellState.SHIP);
                break;
            case RIGHT:
                for (char i = 1; i < size; i++) setCell((char) (c + i), n, CellState.SHIP);
                break;
            case UP:
                for (int i = 1; i < size; i++) setCell(c, n - i, CellState.SHIP);
                break;
            case DOWN:
                for (int i = 1; i < size; i++) setCell(c, n + i, CellState.SHIP);
                break;
        }
    }

    public void clear() {
        for (int i = 0; i < cellStates.length; i++) {
            for (int j = 0; j < cellStates[i].length; j++) {
                cellStates[i][j] = CellState.EMPTY;
            }
        }
    }

    void randomPlaceShip(int size) {
        CellCoordinates randomStartCell;
        do {
            randomStartCell = getRandomCellCoordinates();
        } while (getCellState(randomStartCell) != CellState.EMPTY);
        Set<CellCoordinates> forbiddenStartCells = new HashSet<>();
        Direction randomDirection = Direction.randomDirection();
        if (this.getCellState(randomStartCell) != CellState.EMPTY
                || forbiddenStartCells.contains(randomStartCell)
                || !checkCreateShip(randomStartCell.getCharacter(), randomStartCell.getInteger(), size, randomDirection)) {
            forbiddenStartCells.add(randomStartCell);
            randomPlaceShip(size);
        } else {
            ShipParameters sp = new ShipParameters(randomStartCell, size, randomDirection);
            this.createShip(sp);
            forbiddenStartCells.add(randomStartCell);
        }
    }
}

class CellCoordinates {

    static class WrongCellLetterException extends Exception {
    }

    static class WrongCellNumberException extends Exception {
    }

    private Character character;
    private Integer integer;

    public final static CellCoordinates topLeft = new CellCoordinates('a', 1);
    public final static CellCoordinates bottomRight = new CellCoordinates('j', 10);

    public static CellCoordinates fromString(String str) throws WrongCellLetterException, WrongCellNumberException {
        if (str.isEmpty()) throw new WrongCellLetterException();

        CellCoordinates cc = new CellCoordinates();

        char startCellChar = str.charAt(0);
        if (startCellChar >= 'a' && startCellChar <= 'j') {
            cc.setCharacter(startCellChar);
        } else {
            throw new WrongCellLetterException();
        }

        Integer startCellNum;
        try {
            startCellNum = Integer.parseInt(str.substring(1));
        } catch (NumberFormatException e) {
            throw new WrongCellNumberException();
        }
        if (startCellNum >= 1 && startCellNum <= 10) {
            cc.setInteger(startCellNum);
        } else {
            throw new WrongCellNumberException();
        }

        return cc;
    }

    CellCoordinates() {
    }

    CellCoordinates(Character character, Integer integer) {
        this.character = character;
        this.integer = integer;
    }

    CellCoordinates add(char ch, int i) {
        return new CellCoordinates((char) (this.character + ch), this.integer + i);
    }

    CellCoordinates subtract(char ch, int i) {
        return new CellCoordinates((char) (this.character - ch), this.integer - i);
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }

    Character getCharacter() {
        return character;
    }

    Integer getInteger() {
        return integer;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof CellCoordinates)) return false;
        CellCoordinates other = (CellCoordinates) o;
        return character == other.character && integer.equals(other.integer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCharacter(), getInteger());
    }

    @Override
    public String toString() {
        return String.format("(%c, %d)", character, integer);
    }
}