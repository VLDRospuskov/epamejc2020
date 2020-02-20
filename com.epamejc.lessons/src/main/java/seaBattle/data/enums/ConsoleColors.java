package seaBattle.data.enums;

public enum ConsoleColors {
    RESET("\u001B[0m"),
    RED("\u001B[31m"),
    GREEN_BOLD("\033[1;32m"),
    GREEN("\u001B[32m"),
    BLUE("\u001B[34m"),
    YELLOW("\u001B[33m");

    private String color;

    ConsoleColors(String value) {
        this.color = value;
    }

    public String color() {
        return color;
    }
}
