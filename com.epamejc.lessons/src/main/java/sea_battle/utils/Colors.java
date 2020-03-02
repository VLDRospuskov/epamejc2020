package sea_battle.utils;

public enum Colors {
    GREEN("\u001B[32m"), YELLOW("\u001B[33m"), RED("\u001B[31m"), BLUE("\u001B[34m"), MAIN("\u001B[0m");

    String color;

    Colors(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
