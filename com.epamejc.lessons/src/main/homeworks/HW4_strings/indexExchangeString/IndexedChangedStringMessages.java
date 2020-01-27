package main.homeworks.HW4_strings.indexExchangeString;

enum IndexedChangedStringMessages {
    exitAppMessage("Program ends. Goodbye."),
    enterStringMessage ("Enter the string with length > 0 : "),
    enterIndexMessage("Enter 2 indexes (use random non-word separator char) " +
            "of the recorded string, whose characters you want to change (0 - "),
    wrongStringArgument("Wrong input. Enter correct string."),
    wrongNumberArgument("Wrong input. Enter correct index numbers.");

    private String value;

    IndexedChangedStringMessages(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
