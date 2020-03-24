package homework.Seabattle;

public enum CellState {
    EMPTY,
    MISSED,
    SHIP,
    SHIP_HIT,
    OUT_OF_BOUNDS;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";

    @Override
    public String toString() {
        switch (this) {
            case EMPTY:
                return "_|";
            case SHIP:
                return ANSI_BLUE + "S" + ANSI_RESET + "|";
            case MISSED:
                return ANSI_YELLOW + "O" + ANSI_RESET + "|";
            case SHIP_HIT:
                return ANSI_RED + "X" + ANSI_RESET + "|";
            default:
                return "| |";
        }
    }
}