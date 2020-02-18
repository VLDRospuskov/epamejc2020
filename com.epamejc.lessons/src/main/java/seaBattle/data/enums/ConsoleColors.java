package seaBattle.data.enums;

public enum ConsoleColors {
    RESET("\u001B[0m"),
    RED("\u001B[31m"),
    BLUE("\u001B[34m");

    private String color;

    ConsoleColors(String value) {
        this.color = value;
    }

    public String color() {
        return color;
    }
}
