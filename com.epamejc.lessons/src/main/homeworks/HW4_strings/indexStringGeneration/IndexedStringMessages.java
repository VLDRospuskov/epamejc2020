package main.homeworks.HW4_strings.indexStringGeneration;

enum IndexedStringMessages {
    exitAppMessage("Program ends. Goodbye."),
    enterStringMessage("Enter the string with length > 0: "),
    enterIndexMessage("Type -1 to exit or enter the char index of entered string, you want to add (0 - ");

    private String value;

    IndexedStringMessages(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

