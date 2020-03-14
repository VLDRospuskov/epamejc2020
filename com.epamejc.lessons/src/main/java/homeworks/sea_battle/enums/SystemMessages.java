package homeworks.sea_battle.enums;

public enum SystemMessages {
    GREETINGS("<<<<SEA BATTLE>>>>"),
    CHOOSE_GAME_MODE("1. One player\n" +
            "2. Two players\n" +
            "3. Exit"),
    PLAYER_NAME("enter a name: "),
    CHOOSE_SHIP_SETTER("Would you like set your ships manually? Y/N: "),
    SET_COORDS("Type coordinates where you would like to set a ship: "),
    SET_DIRECTION("Type direction for your ship (up, down, left, right): ");

    public String message;

    SystemMessages(String message) {
        this.message = message;
    }
}