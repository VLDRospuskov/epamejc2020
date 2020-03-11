package homeworks.seabatle.servises.locationservice;

import homeworks.seabatle.exception.IncorrectInputParseException;
import homeworks.seabatle.functional.Calculator;
import homeworks.seabatle.functional.StringMaker;
import homeworks.seabatle.servises.fillservise.FillStrategy;
import homeworks.seabatle.servises.fillservise.GorrizontalFillStrategy;
import homeworks.seabatle.servises.fillservise.VerticalFillStrategy;

import java.util.Arrays;
import java.util.List;

public class LocationServiceImpl implements LocationService {
    private static final List<String> strCoords = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J");
    private static final int XCONST = 10;
    ;
    private Calculator calculator;

    public LocationServiceImpl() {
        calculator = (x, y) -> x * XCONST + y;
    }

    /**
     * method interpritate user input like "A5" or "F3 H6" letters should be from
     * A to J, nums from 1 to 10. for example "B2 B4" = {11,12,13}, J10 = {99}
     *
     * @param request user request
     * @return array with coordinates
     * @throws IncorrectInputParseException if data is incorrect.
     */
    @Override
    public int[] getCoordinates(String request) throws IncorrectInputParseException {
        StringMaker maker = string -> string.replaceAll("[A-Z]", "");
        StringMaker alert = string -> string + " is not valid";
        if (0 < request.length() && request.length() <= 3) {
            int x = checkString(request.substring(0, 1));
            int y = checkInt(maker.make(request));
            return getCoordinates(x, y);
        } else if (5 <= request.length() && request.length() <= 7) {
            String[] coords = request.split("\\s+");
            if (coords.length == 2) {
                int x1 = checkString(coords[0].substring(0, 1));
                int y1 = checkInt(maker.make(coords[0]));
                int x2 = checkString(coords[1].substring(0, 1));
                int y2 = checkInt(maker.make(coords[1]));
                return getCoordinates(x1, y1, x2, y2);
            } else {
                throw new IncorrectInputParseException(alert.make(request));
            }
        } else {
            throw new IncorrectInputParseException(alert.make(request));
        }
    }

    /**
     * method translate coordinates from numeric form to string form,
     * for example coord = 99 , then return "J10".
     *
     * @param coord integer from 0 to 99
     * @return string coordinate
     */
    @Override
    public String translateRequest(int coord) {
        String x = strCoords.get(coord / 10);
        String y = String.valueOf(coord % 10 + 1);
        return x + y;
    }

    private int[] getCoordinates(int x, int y) {
        int[] ints = {calculator.calc(x, y)};
        return ints;
    }

    /**
     * Method make array of coordinates, uses FillStrategy interface
     *
     * @param x1 from 0 to 9
     * @param y1 from 0 to 9
     * @param x2 from 0 to 9
     * @param y2 from 0 to 9
     * @return array of coordinates
     */
    private int[] getCoordinates(int x1, int y1, int x2, int y2) {
        Calculator newLength = (a, b) -> Math.abs(a - b) + 1;
        FillStrategy strategy;
        int firstCell;
        int length;
        if (x2 - x1 == 0) {
            int minY = Math.min(y1, y2);
            firstCell = calculator.calc(x1, minY);
            length = newLength.calc(y2, y1);
            strategy = new GorrizontalFillStrategy();

        } else {
            int minX = Math.min(x1, x2);
            firstCell = calculator.calc(minX, y1);
            length = newLength.calc(x2, x1);
            strategy = new VerticalFillStrategy();
        }
        return strategy.getShipCoords(firstCell, length);
    }

    /**
     * method validate int coordinate
     *
     * @param request int
     * @return return request - 1 if request is from 1 to 10
     * @throws IncorrectInputParseException request is not valid
     */
    private int checkInt(String request) throws IncorrectInputParseException {
        try {
            int coordinate = Integer.parseInt(request) - 1;
            if (0 <= coordinate && coordinate <= 9) {
                return coordinate;
            } else {
                throw new IncorrectInputParseException(request + " should be from \"1\" to \"10\"");
            }
        } catch (NumberFormatException ex) {
            throw new IncorrectInputParseException(request + " is not Integer");
        }
    }

    /**
     * method validate String coordinate, using array stringCoords
     *
     * @param request letter from user input
     * @return integer from 0 to 9
     * @throws IncorrectInputParseException if char is not english and not from A to J
     */
    private int checkString(String request) throws IncorrectInputParseException {
        if (strCoords.contains(request)) {
            return strCoords.indexOf(request);
        } else {
            throw new IncorrectInputParseException(request + " should be from \"A\" to \"J\"");
        }
    }

}
