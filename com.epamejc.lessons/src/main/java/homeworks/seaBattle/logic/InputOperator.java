package homeworks.seaBattle.logic;

import homeworks.seaBattle.data.Cell;
import homeworks.seaBattle.data.Player;
import homeworks.seaBattle.data.enums.ConsoleColors;
import homeworks.seaBattle.data.enums.Directions;
import homeworks.seaBattle.data.enums.SystemMessages;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class InputOperator {

    private final String REGEX = "^(\\w{1,})\\s{1,}(\\d{1,})";
    private String[] parsedIndices = new String[]{"1", "1"};

    /**
     * Method for entering cell coordinates for a shot at an enemy field
     *
     * @param scanner            scanner object
     * @param botPlayer          enemy computer-player object (for using enemy field operations)
     * @param playerShootingUtil human player class with shooting logic
     * @return array of cell indices
     */
    public int[] enterIndexes(Scanner scanner, Player botPlayer, PlayerShootingUtil playerShootingUtil) {
        boolean isInputCorrect = false;
        while (!isInputCorrect) {
            System.out.print(SystemMessages.enterShotCoordinates.getMessage());
            String enteredString = scanner.nextLine();
            System.out.println();
            try {
                if (enteredString.equals("exit")) {
                    Battle.setExitCondition();
                    break;
                } else {
                    parsedIndices = parseIndexesWithRegex(enteredString);
                    isInputCorrect = checkIndices(parsedIndices, botPlayer, playerShootingUtil);
                }
            } catch (Exception ex) {
                System.out.println(ConsoleColors.RED.color() + "Wrong input"
                        + ConsoleColors.RESET.color());
            }
        }
        return convertIndices(parsedIndices);
    }

    /**
     * Method for entering the direction of the ship
     *
     * @param scanner  scanner object
     * @param shipType type of the ship {@link homeworks.seaBattle.data.Ship}
     * @return direction for placing the ship
     */
    public String enterDirection(Scanner scanner, String shipType) {
        boolean isInputCorrect = false;
        String direction = "";
        while (!isInputCorrect) {
            System.out.print(SystemMessages.enterPlacementDirection.getMessage() + shipType + " : ");
            String enteredString = scanner.nextLine().trim();
            System.out.println();
            if (enteredString.equals(Directions.UP.getDirection()) ||
                    enteredString.equals(Directions.RIGHT.getDirection()) ||
                    enteredString.equals(Directions.DOWN.getDirection()) ||
                    enteredString.equals((Directions.LEFT.getDirection()))) {
                return enteredString;
            } else {
                System.out.println(ConsoleColors.RED.color() + "There is no such direction"
                        + ConsoleColors.RESET.color());
            }
        }
        return direction;
    }

    /**
     * Method for choosing the type of ship arrangement (manual or automatic)
     *
     * @param scanner scanner object
     * @return Y (manual) or N (automatic)
     */
    public boolean isManualPlacementRequired(Scanner scanner) {
        boolean isInputCorrect = false;
        while (!isInputCorrect) {
            System.out.print(SystemMessages.choosePlacementType.getMessage());
            String enteredString = scanner.nextLine().trim();
            if (enteredString.toUpperCase().equals("Y")) {
                return true;
            } else if (enteredString.toUpperCase().equals("N")) {
                return false;
            } else {
                System.out.println(SystemMessages.errorManualInput.getMessage());
            }
        }
        return false;
    }

    /**
     * Method for entering cell coordinates for the arrangement of ships ("starting" cell of ship)
     *
     * @param scanner               scanner object
     * @param playerFieldOperations human player {@link FieldOperations} object
     * @param shipType              type of the ship to be placed
     * @return array of cell indices
     */
    public int[] enterIndexes(Scanner scanner, FieldOperations playerFieldOperations, String shipType) {
        boolean isInputCorrect = false;
        while (!isInputCorrect) {
            System.out.print(SystemMessages.enterPlacementCoordinates.getMessage() + shipType + " : ");
            String enteredString = scanner.nextLine();
            System.out.println();
            try {
                if (enteredString.equals("exit")) {
                    ManualShipPlacer.setInputExitCondition();
                    break;
                } else {
                    parsedIndices = parseIndexesWithRegex(enteredString);
                    isInputCorrect = checkIndices(parsedIndices, playerFieldOperations);
                }
            } catch (Exception ex) {
                System.out.println(ConsoleColors.RED.color() + "Wrong input"
                        + ConsoleColors.RESET.color());
            }
        }
        return convertIndices(parsedIndices);
    }

    /**
     * Method decomposes a string with cell indices into 2 components with regex
     *
     * @param inputIndexes entered string with cell indices
     * @return array of 2 components, which are coordinates of a cell
     * @throws IllegalArgumentException exception if there're troubles with splitting of the entered line
     */
    private String[] parseIndexesWithRegex(String inputIndexes) throws IllegalArgumentException {
        String[] indexArray = new String[2];
        Pattern pattern = Pattern.compile(REGEX, Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(inputIndexes);
        if (matcher.find()) {
            if (matcher.groupCount() == 2) {
                try {
                    indexArray[0] = matcher.group(1);
                    indexArray[1] = matcher.group(2);
                    return indexArray;
                } catch (Exception ex) {
                    System.out.println(SystemMessages.errorSplitIndices.getMessage());
                    throw new IllegalArgumentException();
                }
            }
        }
        System.out.println(SystemMessages.errorSplitIndices.getMessage());
        throw new IllegalArgumentException();
    }

    /**
     * Method for checking the entered indices of the cell, the human player is shooting
     *
     * @param parsedIndices      array of 2 components, which are coordinates of a cell
     * @param botPlayer          enemy computer-player object (for using enemy field operations)
     * @param playerShootingUtil human player class with shooting logic (for getting banned cells)
     * @return true/false if player can/can't shoot the cell with entered indices
     */
    private boolean checkIndices(String[] parsedIndices, Player botPlayer, PlayerShootingUtil playerShootingUtil) {
        try {
            if (parsedIndices[0].length() > 1) {
                System.out.println(SystemMessages.errorSingleIndex.getMessage());
                return false;
            }
            int[] potentialCoordinates = convertIndices(parsedIndices);
            Cell potentialFireCell = botPlayer.fieldOperations()
                    .getCellByCoords(potentialCoordinates[0], potentialCoordinates[1]);

            if (potentialFireCell == null) {
                System.out.println(SystemMessages.errorNoSuchCell.getMessage());
                return false;
            }
            if (playerShootingUtil.isCellShot(potentialFireCell)) {
                System.out.println(SystemMessages.errorNoShootHere.getMessage());
                return false;
            }
            return true;

        } catch (Exception ex) {
            System.out.println(SystemMessages.errorCantConvertAndCheck.getMessage());
            return false;
        }
    }

    /**
     * Method for checking the entered indices of the cell, which'll be the starting point of the placed ship
     *
     * @param parsedIndices         array of 2 components, which are coordinates of a cell
     * @param playerFieldOperations human player {@link FieldOperations} object
     * @return true/false if player can/can't can place ship from this starting cell
     */
    private boolean checkIndices(String[] parsedIndices, FieldOperations playerFieldOperations) {
        try {
            if (parsedIndices[0].length() > 1) {
                System.out.println(SystemMessages.errorSingleIndex.getMessage());
                return false;
            }
            int[] potentialCoordinates = convertIndices(parsedIndices);
            Cell potentialFireCell = playerFieldOperations
                    .getCellByCoords(potentialCoordinates[0], potentialCoordinates[1]);

            if (potentialFireCell == null) {
                System.out.println(SystemMessages.errorNoSuchCell.getMessage());
                return false;
            }
            return true;

        } catch (Exception ex) {
            System.out.println(SystemMessages.errorCantConvertAndCheck.getMessage());
            return false;
        }
    }

    /**
     * Method to convert letter to number
     *
     * @param index letter-index
     * @return number-index
     */
    private int convertLetterToInt(String index) {
        return Character.toLowerCase(index.charAt(0)) - 96;
    }

    /**
     * Method for creating an array of converted indices
     *
     * @param parsedIndices array of 2 letter coordinates
     * @return array of 2 number-coordinates
     */
    private int[] convertIndices(String[] parsedIndices) {
        int[] convertedIndices = new int[2];
        convertedIndices[0] = convertLetterToInt(parsedIndices[0]);
        convertedIndices[1] = parseInt(parsedIndices[1]);
        return convertedIndices;
    }
}
