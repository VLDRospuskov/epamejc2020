package homeworks.newSeabattle.data.enums;

public enum Messages {

    GREETING("Welcome to the \"SeaBattle\" game!"),
    CHOOSE_PLAYERS("How many players, 1 or 2? "),
    ERROR_WHILE_GAME_TYPE_CHOOSING("1 or 2 only: "),
    NAME("Player's name: "),
    MANUAL_CREATION("Generate ships manually (1-yes, 0-no) ");

    private String str;

    Messages(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return str;
    }

}
