package main.homeworks.HW4_strings.indexExchangeString;

enum IndexedChangedStringMessages {
    exitAppMessage("Program ends. Goodbye."),
    enterStringMessage ("Enter the string with length > 0: "),
    enterIndexMessage("Type -1 to exit or enter 2 indexes (use random non-word separator char) " +
            "of the recorded string, whose characters you want to change (0 - ");

    private String value;

    IndexedChangedStringMessages(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
