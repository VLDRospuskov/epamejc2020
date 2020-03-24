package homework.Seabattle;

public class OutputFormatter {

    public enum TextColor {
        BLACK,
        RED,
        GREEN,
        YELLOW,
        BLUE,
        PURPLE,
        CYAN,
        WHITE;

        public static final String ANSI_RESET = "\u001B[0m";
        public static final String ANSI_BLACK = "\u001B[30m";
        public static final String ANSI_RED = "\u001B[31m";
        public static final String ANSI_GREEN = "\u001B[32m";
        public static final String ANSI_YELLOW = "\u001B[33m";
        public static final String ANSI_BLUE = "\u001B[34m";
        public static final String ANSI_PURPLE = "\u001B[35m";
        public static final String ANSI_CYAN = "\u001B[36m";
        public static final String ANSI_WHITE = "\u001B[37m";

        @Override
        public String toString() {
            switch (this) {
                case BLACK:
                    return ANSI_BLACK;
                case RED:
                    return ANSI_RED;
                case GREEN:
                    return ANSI_GREEN;
                case YELLOW:
                    return ANSI_YELLOW;
                case BLUE:
                    return ANSI_BLUE;
                case PURPLE:
                    return ANSI_PURPLE;
                case CYAN:
                    return ANSI_CYAN;
                case WHITE:
                    return ANSI_WHITE;
                default:
                    return "";
            }
        }
    }

    public static void printColored(String str, TextColor tc) {
        System.out.println(tc + str + TextColor.ANSI_RESET);
    }
}
