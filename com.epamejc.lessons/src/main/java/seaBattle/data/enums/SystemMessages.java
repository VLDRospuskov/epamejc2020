package seaBattle.data.enums;

public enum SystemMessages {
    startGame("Welcome to seabattle game"),
    enterIndex("Enter the coordinates of the cell: "),
    playerHit("You hit computer ship");

    private String message;
    SystemMessages(String value) {
        this.message = value;
    }
    public String getMessage() {
        return message;
    }
}
