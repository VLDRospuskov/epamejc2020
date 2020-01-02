package main.homeworks.hw1ver2.enums;

public enum Messages {

    EXIT_COMMAND("exit"),
    ENTER_MESSAGE("Enter time in minutes. You can enter not only integer numbers, " +
                          "but it should be positive. To exit print \" exit \"."),
    ENTER_NUMBER_COMMAND("You have to enter a positive number"),
    GREEN_LIGHT_MESSAGE("Green light is ON"),
    YELLOW_LIGHT_MESSAGE("Yellow light is ON"),
    RED_LIGHT_MESSAGE("Red light is ON");

    private String enumValue;

    Messages(String message) {
        this.enumValue = message;
    }

    @Override
    public String toString() {
        return enumValue;
    }
}
