package seaBattle.data.enums;

public enum SystemMessages {
    startGame("Welcome to seabattle game"),
    enterIndex("Enter the coordinates of the cell: "),
    playerMiss("You missed"),
    playerHit("You hit an enemy ship"),
    playerKill("You destroyed an enemy ship"),
    botMiss("Bot missed"),
    botHit("Bot hit your ship"),
    botKill("Bot destroyed your ship");

    private String message;
    SystemMessages(String value) {
        this.message = value;
    }
    public String getMessage() {
        return message;
    }
}
