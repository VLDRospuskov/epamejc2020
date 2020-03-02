package homeworks.seaBattle.logic;

import homeworks.seaBattle.data.Cell;
import homeworks.seaBattle.data.Ship;
import homeworks.seaBattle.data.enums.Directions;
import homeworks.seaBattle.data.enums.SystemMessages;

import java.util.List;
import java.util.Scanner;

public class ManualShipPlacer {

    private FieldPrinter fieldPrinter;
    private FieldOperations fieldOperations;
    private InputOperator inputOperator;
    private static boolean isInputExitCondition = false;

    public ManualShipPlacer(FieldOperations fieldOperationsObject) {
        this.fieldOperations = fieldOperationsObject;
        this.fieldPrinter = new FieldPrinter();
        this.inputOperator = new InputOperator();
    }

    public static void setInputExitCondition() {
        isInputExitCondition = true;
    }

    /**
     * Method for ship placement
     * @param ships {@link Ship} to be placed
     * @param scanner {@link Scanner} object
     */
    public void placeShips(List<Ship> ships, Scanner scanner) {
        System.out.println("Place ships manually");
        for (Ship ship : ships) {
            if (ship.getShipDecks() > 1) {
                placeShip(ship, scanner);
            } else {
                placeSingleShip(ship, scanner);
            }
            if (isInputExitCondition) {
                break;
            }
        }
        if (isInputExitCondition) {
            Application.setApplicationExitCondition();
        }
    }

    /**
     * Method for checking entered direction for ship placement
     * @param ship ship to be placed
     * @param direction direction for placement
     * @return true/false, if ship can be placed in this direction
     */
    public boolean checkPotentialDirection(Ship ship, String direction) {
        if (fieldOperations.checkFieldBorder(direction, ship.getShipCoordX(),
                ship.getShipCoordY(), ship.getShipDecks())) {
            ship.setDirection(direction);
            List<Cell> radiusList = fieldOperations.getShipAndRadiusCells(ship);
            for (Cell c : radiusList) {
                if (c.getCellShip() != null) {
                    System.out.println(SystemMessages.errorAnotherShipHere.getMessage());
                    return false;
                }
            }
            return true;
        } else {
            System.out.println(SystemMessages.errorCrossBorder.getMessage());
            return false;
        }
    }

    /**
     * Method for checking entered coordinates for ship placement
     * @param ship {@link Ship} to be placed
     * @param indexes vertical and horizontal coordinates of the cell for placement
     * @return true/false, if ship can be placed at these coordinates
     */
    public boolean checkEnteredCoordinates(Ship ship, int[] indexes) {
        Cell potentialPlacementCell = fieldOperations.getCellByCoords(indexes[0], indexes[1]);
        if (potentialPlacementCell.getCellShip() == null) {
            pinPotentialCellAndShip(ship, potentialPlacementCell);
            if (fieldOperations.getPotentialDirectionsNumber(ship, potentialPlacementCell) > 0) {
                return true;
            }
        }
        System.out.println(SystemMessages.errorCantPlaceHere.getMessage());
        unPinPotentialCellAndShip(ship, potentialPlacementCell);
        return false;
    }

    /**
     * Method for placement single-deck ship
     * @param ship {@link Ship} to be placed
     * @param scanner {@link Scanner} object
     */
    private void placeSingleShip(Ship ship, Scanner scanner) {
        System.out.println("Placing " + ship.getShipType() + " ship");
        boolean isCellFixed = false;
        while (!isCellFixed && !isInputExitCondition) {
            fieldPrinter.printSingleField(fieldOperations.getField());
            int[] indexes = inputOperator.enterIndexes(scanner, fieldOperations, ship.getShipType());
            if (!isInputExitCondition) {
                Cell potentialPlacementCell = fieldOperations.getCellByCoords(indexes[0], indexes[1]);
                if (potentialPlacementCell.getCellShip() == null) {
                    pinPotentialCellAndShip(ship, potentialPlacementCell);
                    if (fieldOperations.getPotentialDirectionsNumber(ship, potentialPlacementCell) > 0) {
                        if (checkSingleShip(ship) == 0) {
                            ship.setDirection(Directions.UP.getDirection());
                            initializeShip(ship);
                            break;
                        }
                    }
                }
                System.out.println(SystemMessages.errorCantPlaceHere.getMessage());
                unPinPotentialCellAndShip(ship, potentialPlacementCell);
            }
        }
    }

    /**
     * Method for ship placement
     * @param ship {@link Ship} to be placed
     * @param scanner {@link Scanner} object
     */
    private void placeShip(Ship ship, Scanner scanner) {
        System.out.println("Placing " + ship.getShipType() + " ship");
        boolean isCellFixed = false;
        while (!isCellFixed && !isInputExitCondition) {
            fieldPrinter.printSingleField(fieldOperations.getField());
            int[] indexes = inputOperator.enterIndexes(scanner, fieldOperations, ship.getShipType());
            if (!isInputExitCondition) {
                if (checkEnteredCoordinates(ship, indexes)) break;
            }
        }
        if(!isInputExitCondition) {
            processPlacementDirection(ship, scanner);
        }
    }

    /**
     * Method for initializing the direction of the ship
     * @param ship ship to be placed
     * @param scanner scanner object
     */
    private void processPlacementDirection(Ship ship, Scanner scanner) {
        boolean isDirectionEntered = false;
        while (!isDirectionEntered) {
            fieldPrinter.printSingleField(fieldOperations.getField());
            String direction = inputOperator.enterDirection(scanner, ship.getShipType());
            if (checkPotentialDirection(ship, direction)) {
                initializeShip(ship);
                break;
            }
        }
    }

    /**
     * Method changes starting placement cell status and fixes coordinates of the ship
     * @param ship ship to be placed
     * @param cell starting placement cell
     */
    private void pinPotentialCellAndShip(Ship ship, Cell cell) {
        cell.setInitializationCell();
        ship.setShipCoordX(cell.getxCoord());
        ship.setShipCoordY(cell.getyCoord());
    }

    /**
     * Method removes starting placement cell status and removes coordinates of the ship
     * @param ship ship to be placed
     * @param cell starting placement cell
     */
    private void unPinPotentialCellAndShip(Ship ship, Cell cell) {
        cell.cleatInitializationStatus();
        ship.setShipCoordX(1);
        ship.setShipCoordY(1);
    }

    /**
     * Method for initializing {@link Ship} attributes
     * @param ship ship to be placed
     */
    private void initializeShip(Ship ship) {
        Cell placementCell = fieldOperations.getCellByCoords(ship.getShipCoordX(), ship.getShipCoordY());
        placementCell.cleatInitializationStatus();
        List<Cell> shipCells = fieldOperations.getShipCells(ship);
        for (Cell cell : shipCells) {
            cell.setCellShip(ship);
        }
    }

    /**
     * Method returns the number of ships within the radius of the placed ship
     * @param ship ship to be placed
     * @return number of another ships around placement ship
     */
    private long checkSingleShip(Ship ship) {
        return fieldOperations.getRightDirectionRadius(ship.getShipCoordX(), ship.getShipCoordY(), ship.getShipDecks())
                .stream().filter(c -> c.getCellShip() != null).count();
    }
}
