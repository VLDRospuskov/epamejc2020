package main.homeworks.HW4_strings.stringReverse;

enum ReversedStringMessages {
    exitAppMessage("Program ends. Goodbye."),
    enterStringMessage ("Type -1 to exit or enter a few words separated by a space: ");

    private String value;

    ReversedStringMessages(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
