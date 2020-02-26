package homeworks.java.hw3.enums;

public enum Messages {

    ARRAYS_ENTER_MESSAGE("Input 1, 2 or 3 to choose the program and press enter.\n" +
            "   1 - array maker with random chars inside\n" +
            "   2 - square array maker with random chars inside and two types of outputting:\n" +
            "       like *_*_* or like _*_*_\n" +
            "   3 - pyramid maker."),
    WARNING_FOR_TASK_NUMBER_INPUT("You have to put 1, 2 or 3 for choosing the task number"),
    WARNING_FOR_PARSING_TO_INT("Exception while parsing string from buffer to integer. You have to input only " +
            "a positive numbers"),
    FIRST_TASK_ENTER_MESSAGE("Input number of lines, press enter, input number of columns and press enter again"),
    SECOND_TASK_ENTER_MESSAGE("Input a size of the array, press enter,\nthen choose an input strategy " +
            "and press enter again" + "\nOutputting strategies: \n" +
            "A - is a *_*_* principle\nB - is a _*_*_ principle\n"),
    THIRD_TASK_ENTER_MESSAGE("Input number of pyramids lines. Press enter.\n" +
            "Then input char to full pyramid by it. Press enter"),
    OUTPUT_STRATEGY_CHOOSE_WARNING("You have to put A or B when choosing strategy"),
    FIRST_TASK_EXECUTING_EXCEPTION("Exception while executing 1st task"),
    SECOND_TASK_EXECUTING_EXCEPTION("Exception while executing 2nd task"),
    THIRD_TASK_EXECUTING_EXCEPTION("Exception while executing 3rd task");

    private String enumValue;

    Messages(String message) {
        this.enumValue = message;
    }

    @Override
    public String toString() {
        return enumValue;
    }
}
