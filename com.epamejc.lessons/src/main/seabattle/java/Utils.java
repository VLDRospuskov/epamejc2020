package seabattle.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Utils {

    public static HashMap<String, Integer> keyMap() {
        HashMap<String, Integer> dictionary = new HashMap<>();
        dictionary.put("A", 0);
        dictionary.put("B", 1);
        dictionary.put("C", 2);
        dictionary.put("D", 3);
        dictionary.put("E", 4);
        dictionary.put("F", 5);
        dictionary.put("G", 6);
        dictionary.put("H", 7);
        dictionary.put("I", 8);
        dictionary.put("J", 9);
        return dictionary;
    }

    public static void clearScreen() {
        System.out.println("\n");
    }

    public static void printField(Field field) {
        System.out.println("");
        System.out.println("    A  B  C  D  E  F  G  H  I  J");
        int index = 1;
        for (ArrayList row : field.getField()) {
            System.out.printf("%2d  ", index);
            ArrayList<Cell> col = row;
            for (Cell cell : col) {
                System.out.print(cell + "  ");
            }
            index++;
            System.out.println("");
        }
        clearScreen();
    }

    public static void printHiddenField(Field field) {
        System.out.println("");
        System.out.println("    A  B  C  D  E  F  G  H  I  J");
        int index = 1;
        for (ArrayList row : field.getField()) {
            System.out.printf("%2d  ", index);
            ArrayList<Cell> col = row;
            for (Cell cell : col) {
                System.out.print(cell.printHidden() + "  ");
            }
            index++;
            System.out.println("");
        }
        clearScreen();
    }

    public static void printTwoFields(Field field1, Field field2) {
        System.out.println("\n           YOUR FIELD                                ENEMY FIELD       ");
        System.out.println("    A  B  C  D  E  F  G  H  I  J              A  B  C  D  E  F  G  H  I  J");
        int index = 1;
        for (int i = 0; i < 10; i++) {
            System.out.printf("%2d  ", index);
            ArrayList<Cell> col1 = field1.getField().get(i);
            for (Cell cell : col1) {
                System.out.print(cell + "  ");
            }
            System.out.print("        ");
            System.out.printf("%2d  ", index);
            ArrayList<Cell> col2 = field2.getField().get(i);
            for (Cell cell : col2) {
                System.out.print(cell.printHidden() + "  ");
            }
            index++;
            System.out.println("");
        }
        clearScreen();
    }

    private static String scanInput() {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        if (input.equals("exit")) {
            System.exit(0); // убрать перед сдачей
            }
        return input;
    }

    public static Integer[] scanCoordinates() {
        HashMap<String, Integer> dictionary = keyMap();
        Integer[] coordYX = new Integer[2];
        boolean isBadEnter = true;
        while (isBadEnter) {
            try {
                System.out.print("\nPlease enter coordinate with a space(example \"10 F\"): ");
                String[] input = scanInput().split(" ");
                coordYX[0] = (Integer.parseInt(input[0])) - 1;
                coordYX[1] = dictionary.get(input[1].toUpperCase());
                isBadEnter = checkCoordinates(coordYX);
                if (isBadEnter) {
                    throw new NumberFormatException();
                }
            } catch (Exception e) {
                System.out.println("\nBad coordinates. Try again.");
            }
        }
        return coordYX;
    }

    public static boolean checkCoordinates(Integer[] coordYX) {
        return coordYX[0] == null || coordYX[1] == null || coordYX[0] > 9 || coordYX[1] > 9;
    }

    public static Integer scanShipType() {
        Integer shipType = null;
        boolean isBadEnter = true;
        while (isBadEnter) {
            try {
                System.out.println("\nEnter ship type. It matches to the number of occupied cells.");
                System.out.print("Please enter ship type(1-4): ");
                String input = scanInput();
                shipType = Integer.parseInt(input);
                isBadEnter = checkShipType(shipType);
                if (isBadEnter) {
                    throw new NumberFormatException();
                }
            } catch (Exception e) {
                System.out.println("\nBad type. Try again.");
            }
        }
        return shipType;
    }

    public static boolean checkShipType(Integer shipType) {
        if (shipType < 1 || shipType > 4) {
            return true;
        }
        return false;
    }

    public static ArrayList scanShipParams(Field field) {
        ArrayList params = null;
        boolean isLimitOfShip = true;

        while (isLimitOfShip) {
            params = new ArrayList();
            int shipType = scanShipType();
            params.add(shipType);
            boolean isVacant = checkShipCount(field, shipType);

            if (isVacant){
                System.out.println("\nЕnter the coordinates of the cell in which the beginning of the ship will be.");
                params.add(scanCoordinates());
                System.out.println("\nЕnter the coordinates of the cell in which the end of the ship will be.");
                params.add(scanCoordinates());
                isLimitOfShip = false;
            } else {
                System.out.println("\nThe limit of ships of this type has been reached. Add another ship type!");
            }
        }
        params = sortCoordinatesAscending(params);
        return params;
    }

    public static ArrayList sortCoordinatesAscending(ArrayList params) {
        Integer[] startYX = (Integer[]) params.get(1);
        Integer[] endYX = (Integer[]) params.get(2);
        if(startYX[0] > endYX[0] || startYX[1] > endYX[1]) {
            Integer[] temp = startYX;
            startYX = endYX;
            endYX = temp;
        }
        params.set(1, startYX);
        params.set(2, endYX);
        return params;
    }

    public static boolean checkShipCount(Field field, int shipType) {
        int actualCount = (int) field.getShips().stream()
                .filter(ship -> ship.getShipType().equals(shipType))
                .count();
        int maxCount = getMaxCountOfShipByType(shipType);
        if (actualCount < maxCount) {
            return true;
        }
        return false;
    }

    public static int getMaxCountOfShipByType(int shipType) {
        if(shipType == 4) {
            return 1;
        } else if (shipType == 3) {
            return 2;
        } else if (shipType == 2) {
            return 3;
        }
        return 4;
    }

}
