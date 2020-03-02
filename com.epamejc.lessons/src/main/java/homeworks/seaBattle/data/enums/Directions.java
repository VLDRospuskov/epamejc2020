package homeworks.seaBattle.data.enums;

public enum Directions {
    UP("up"),
    RIGHT("right"),
    DOWN("down"),
    LEFT("left");

    private String direction;

    Directions(String value) {
        this.direction = value;
    }

    public String getDirection() {
        return direction;
    }
}
