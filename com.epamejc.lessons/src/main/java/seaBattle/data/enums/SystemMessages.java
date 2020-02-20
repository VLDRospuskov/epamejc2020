package seaBattle.data.enums;

public enum SystemMessages {
    startGame("Welcome to seabattle game"),
    enterIndex("Enter the coordinates of the cell: "),
    playerMiss(ConsoleColors.YELLOW.color() + "You missed" + ConsoleColors.RESET.color()),
    playerHit(ConsoleColors.GREEN.color() + "You hit an enemy ship" + ConsoleColors.RESET.color()),
    playerKill(ConsoleColors.GREEN.color() + "You destroyed an enemy" + ConsoleColors.RESET.color()),
    botMiss(ConsoleColors.YELLOW.color() + "Computer missed" + ConsoleColors.RESET.color()),
    botHit(ConsoleColors.RED.color() + "Computer hit your ship" + ConsoleColors.RESET.color()),
    botKill(ConsoleColors.RED.color() + "Computer destroyed your ship" + ConsoleColors.RESET.color()),
    playerWin("Congratulations! You won the game"),
    botWin("Computer won the game");

    private String message;
    SystemMessages(String value) {
        this.message = value;
    }
    public String getMessage() {
        return message;
    }
}
