package seaBattle.logic;

import seaBattle.data.Configuration;
import seaBattle.data.enums.ConsoleColors;
import seaBattle.data.enums.SystemMessages;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class InputOperator {

    private final String REGEX = "^(\\w{1,})\\s{1,}(\\d{1,})";
    private String[] parsedIndices;

    public int[] enterIndexes(Scanner scanner) {
        boolean isInputCorrect = false;
        while (!isInputCorrect) {
            System.out.print(SystemMessages.enterIndex.getMessage());
            String enteredString = scanner.nextLine();
            try {
                if (enteredString.equals("exit")) {
                    Battle.setExitCondition();
                    break;
                } else {
                    parsedIndices = parseIndexesWithRegex(enteredString);
                    isInputCorrect = checkIndices(parsedIndices);
                }
            } catch (Exception ex) {
                System.out.println(ConsoleColors.RED.color() + "Wrong input"
                        + ConsoleColors.RESET.color());
            }
        }
        return convertIndices(parsedIndices);
    }

    private String[] parseIndexesWithRegex(String inputIndexes) throws IllegalArgumentException {
        String [] indexArray = new String[2];
        Pattern pattern = Pattern.compile(REGEX, Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(inputIndexes);
        if (matcher.find()) {
            if (matcher.groupCount() == 2) {
                try {
                    indexArray[0] = matcher.group(1);
                    indexArray[1] = matcher.group(2);
                    return indexArray;
                } catch (Exception ex) {
                    System.out.println(ConsoleColors.RED.color() + "Can't parse indices"
                            + ConsoleColors.RESET.color());
                    throw new IllegalArgumentException();
                }
            }
        }
        throw new IllegalArgumentException();
    }

    private boolean checkIndices(String[] parsedIndices) {
        try {
            if (parsedIndices[0].length() > 1) {
                return false;
            }
            if (convertLetterToInt(parsedIndices[0]) < 1
                    || convertLetterToInt(parsedIndices[0]) > Configuration.getFieldSize()) {
                return false;
            }
            int yCoord = parseInt(parsedIndices[1]);
            if (yCoord < 1 || yCoord > Configuration.getFieldSize()){
                return false;
            }
            return true;
        } catch (Exception ex) {
            System.out.println("Can't convert indices");
            return false;
        }
    }

    private int convertLetterToInt(String index) {
        return Character.toLowerCase(index.charAt(0)) - 96;
    }

    private int[] convertIndices(String[] parsedIndices) {
        int[] convertedIndices = new int[2];
        convertedIndices[0] = convertLetterToInt(parsedIndices[0]);
        convertedIndices[1] = parseInt(parsedIndices[1]);
        return convertedIndices;
    }
}
