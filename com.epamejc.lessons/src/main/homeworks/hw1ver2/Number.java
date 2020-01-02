package main.homeworks.hw1;

import static main.homeworks.hw1.enums.Messages.ENTER_NUMBER_COMMAND;

public class Number {

    static Double getNumberFromInput(String line) {

        Double d = null;

        try {
            if (Double.parseDouble(line) > 0) {
                return Double.parseDouble(line);
            }
            else {
                System.out.println(ENTER_NUMBER_COMMAND.toString());
            }
        } catch (NumberFormatException e) {
            System.out.println(ENTER_NUMBER_COMMAND.toString());
        }
        return d;
    }

}
