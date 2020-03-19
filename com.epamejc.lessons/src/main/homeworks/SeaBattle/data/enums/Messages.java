package homeworks.SeaBattle.data.enums;

public enum Messages {

    GREETING("Welcome to the \"SeaBattle\" game!"),
    CHOOSE_PLAYERS("How many players, 1 or 2? "),
    ERROR_WHILE_GAME_TYPE_CHOOSING("1 or 2 only: "),
    NAME("Player's name: "),
    MANUAL_CREATION("Generate ships manually (1-yes, 0-no) "),
    MISS("Miss!"),
    HIT("Hit!"),
    DESTROYED("Destroyed!"),
    WRONG_SHIP_PLACEMENT("The ship cannot be put this way!"),
    GETTING_DIRECTION("Input direction (down or right): "),
    WRONG_DIRECTION_INPUT("Input only right or down"),
    INPUT_FOR_SHOOTING("Input (a1 format): "),
    ENDGAME("Thank you for the game!"),
    USER_TURN_FINISHED("Your turn is finished. Press any button."),
    COMPUTER_TURN_FINISHED("Computer's turn is finished."),
    COMPUTER_TURN_STARTED("It's computer's turn!");

    private String str;

    Messages(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return str;
    }

}
