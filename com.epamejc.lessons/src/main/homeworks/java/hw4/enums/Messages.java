package main.homeworks.java.hw4.enums;

public enum Messages {

    STRINGS_ENTER_MESSAGE("Input 1, 2, 3 or 4 to choose the program and press enter.\n" +
            "1 - returns even or odd chars of the line\n" +
            "2 - makes line by specified indexes\n" +
            "3 - replaces two specified chars in the line\n" +
            "4 - reverses words in the line but leaves them on there initial places"),
    WARNING_FOR_TASK_NUMBER_INPUT("There is no program with that number"),
    WARNING_FOR_PARSING_TO_INT("Problem is in parsing of the task number"),
    EVEN_OR_ODD_ENTER_MESSAGE("Input working line, press enter.\n" +
            "Then input even or odd strategy of outputting. Press enter"),
    LINE_FROM_INDEXES_ENTER_MESSAGE("Input working line. Press enter.\n" +
            "Then input indexes of chars which you want to see divided by space (\" \"). Press enter"),
    REPLACE_CHARS_ENTER_MESSAGE("Input working line. Press enter.\n" +
            "Then input which of two indexes of that line need to be exchanged. Press enter after each index input"),
    REVERSE_WORDS_ENTER_MESSAGE("Input working line. Press enter"),
    INPUT_WARNING("Something is wrong in inputs"),
    ONLY_POSITIVE_NUMBER_WARNING("Input only positive numbers for indexes");

    private String enumValue;

    Messages(String message) {
        this.enumValue = message;
    }

    @Override
    public String toString() {
        return enumValue;
    }
}
