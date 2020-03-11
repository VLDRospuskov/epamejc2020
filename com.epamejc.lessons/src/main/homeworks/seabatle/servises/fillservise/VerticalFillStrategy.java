package homeworks.seabatle.servises.fillservise;

public class VerticalFillStrategy implements FillStrategy {
    /**
     * method produces array of vertical coordinates
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
            firstCell += 10;
        }
        return coords;
    }
}
