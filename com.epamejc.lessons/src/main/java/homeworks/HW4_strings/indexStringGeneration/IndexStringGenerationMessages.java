package homeworks.HW4_strings.indexStringGeneration;

enum IndexStringGenerationMessages {
    exitAppMessage("Program ends. Goodbye."),
    enterStringMessage("Enter the string with length > 0: "),
    enterStringError("Wrong input. Enter correct string."),
    enterIndexError("Wrong input. Enter correct index."),
    enterIndexMessage("Type -1 to exit or enter the char index of entered string, you want to add (0 - ");

    private String value;

    IndexStringGenerationMessages(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

