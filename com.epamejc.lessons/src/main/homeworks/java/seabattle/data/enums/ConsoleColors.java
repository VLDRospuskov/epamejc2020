package homeworks.java.seabattle.data.enums;

public enum ConsoleColors {

    RESET("\033[0m"),
    RED("\033[0;31m"),
    GREEN("\033[0;32m");

    private String color;

    ConsoleColors(String value) {

        this.color = value;

    }

    public String color() {

        return color;

    }

}
