package main.homeworks.HW4_strings.evenOrOddString;

public enum FilterTypes {
    EVEN("even"),
    ODD("odd"),
    wrongArgument("Wrong input. Enter correct string.");

    private String value;

    FilterTypes(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
