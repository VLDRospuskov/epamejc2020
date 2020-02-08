package homeworks.HW4_strings.evenOrOddString;

public enum FilterTypes {
    EVEN("even"),
    ODD("odd"),
    wrongArgument("Wrong input. Enter correct string."),
    enterStringMessage("Enter the string with length > 0. Type \"exit\" to finish program: "),
    enterFilterTypeMessage("Select characters to be removed from string (enter even or odd): ");

    private String value;

    FilterTypes(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
