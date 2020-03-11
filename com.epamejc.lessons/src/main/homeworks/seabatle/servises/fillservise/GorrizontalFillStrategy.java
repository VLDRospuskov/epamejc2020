package homeworks.seabatle.servises.fillservise;

import java.util.stream.Stream;

public class GorrizontalFillStrategy implements FillStrategy {
    /**
     * method produces array of horizontal coordinates
     *
     * @param firstCell first coordinate
     * @param length    array length
     * @return array of coordinates
     */
    @Override
    public int[] getShipCoords(int firstCell, int length) {
        int[] coords = new int[length];
        for (int i = 0; i < length; i++) {
            coords[i] = firstCell;
            firstCell++;
        }
        return coords;
    }
}
