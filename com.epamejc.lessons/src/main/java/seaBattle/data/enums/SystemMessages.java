package seaBattle.data.enums;

public enum SystemMessages {
    startGame("Welcome to seabattle game"),
    choosePlacementType("Do you want to place your ships manually? (Y/N): "),
    enterShotCoordinates("Enter the coordinates of the cell you want to shoot: "),
    enterPlacementCoordinates("Enter the coordinates of the cell you want to place your "),
    enterPlacementDirection("Enter the direction you want to place your "),
    playerMiss(ConsoleColors.YELLOW.color() + "You missed" + ConsoleColors.RESET.color()),
    playerHit(ConsoleColors.GREEN.color() + "You hit an enemy ship" + ConsoleColors.RESET.color()),
    playerKill(ConsoleColors.GREEN.color() + "You destroyed an enemy" + ConsoleColors.RESET.color()),
    botMiss(ConsoleColors.YELLOW.color() + "Computer missed" + ConsoleColors.RESET.color()),
    botHit(ConsoleColors.RED.color() + "Computer hit your ship" + ConsoleColors.RESET.color()),
    botKill(ConsoleColors.RED.color() + "Computer destroyed your ship" + ConsoleColors.RESET.color()),
    playerWin("Congratulations! You won the game"),
    botWin("Computer won the game"),
    errorManualInput(ConsoleColors.RED.color() + "Incorrect option, repeat your answer"
            + ConsoleColors.RESET.color()),
    errorSplitIndices(ConsoleColors.RED.color() + "Unable to split entered line into coordinates"
            + ConsoleColors.RESET.color()),
    errorSingleIndex(ConsoleColors.RED.color() + "First index is longer, than one char"
            + ConsoleColors.RESET.color()),
    errorNoSuchCell(ConsoleColors.RED.color() + "There is no cell with such coordinates"
            + ConsoleColors.RESET.color()),
    errorNoShootHere(ConsoleColors.RED.color() + "You can’t shoot here"
            + ConsoleColors.RESET.color()),
    errorCantConvertAndCheck(ConsoleColors.RED.color() + "Can't convert and check coordinates"
            + ConsoleColors.RESET.color()),
    errorCrossBorder(ConsoleColors.RED.color() + "In this direction the ship crosses the border"
            + ConsoleColors.RESET.color()),
    errorCantPlaceHere(ConsoleColors.RED.color() + "You can't place ship here (already shipped or no directions)"
            + ConsoleColors.RESET.color()),
    errorAnotherShipHere(ConsoleColors.RED.color() + "There is another ship in that direction"
            + ConsoleColors.RESET.color());

    private String message;
    SystemMessages(String value) {
        this.message = value;
    }
    public String getMessage() {
        return message;
    }
}
