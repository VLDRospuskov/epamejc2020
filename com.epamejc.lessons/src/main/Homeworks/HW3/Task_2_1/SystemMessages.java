package main.Homeworks.HW3.Task_2_1;

public enum SystemMessages {
    appStartMessage("Enter the number of rows and columns to generate the array. " +
            "The number must be between 1 and 85. Enter -1 to exit."),
    appFinishMessage("Program ends. Goodbye."),
    inputLinesMessage("Enter the number of lines: "),
    inputRowsMessage("Enter the number of rows: "),
    outputMessage("Generated array:"),
    numberErrorMessage("Quantity of rows and columns must be a number between 0 and 85");

    private String message;

    SystemMessages(String value) {
        this.message = value;
    }

    public String getMessage() {
        return message;
    }
}
