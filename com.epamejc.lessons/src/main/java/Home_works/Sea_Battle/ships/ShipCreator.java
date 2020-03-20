package Home_works.Sea_Battle.ships;
import java.util.*;

public class ShipCreator {
    private boolean successPickShip;
    Random random = new Random();

    public boolean setShip(CoordinatesList coordinatesList, int deck) {
        List<Coordinates> shipOnMap;
        Set<Integer> edgeCoordinatesList;

        successPickShip = true;
        shipOnMap = getShipCoordinates(deck, coordinatesList);

        if (!successPickShip) {
            return false;
        }
        edgeCoordinatesList = getShipEdge(shipOnMap, coordinatesList);

        setupShip(shipOnMap);
        setupEdge(edgeCoordinatesList, coordinatesList);
        return true;
    }

    /**
     * getShipCoordinates is create and setup ship on map;
     * return boolean;
     * <p>
     * return List<Coordinates> shipOnMap;
     */
    private List<Coordinates> getShipCoordinates(int deck, CoordinatesList coordinatesList) {
        int edge = 10 - deck;
        edge += 1;
        int numeral = getRandom(edge);
        int alphabetic = getRandom(edge);
        List<Coordinates> shipOnMap = new ArrayList<>();
        shipOnMap.add(coordinatesList.getList().get(coordinatesList.getElement(numeral, alphabetic)));
        boolean randomShipVector = getRandom(10) % 2 == 0;

        for (int i = 1; i < deck; i++) {
            if (randomShipVector) {
                numeral++;
            } else {
                alphabetic++;
            }
            shipOnMap.add(coordinatesList.getList().get(coordinatesList.getElement(numeral, alphabetic)));
        }

        for (int i = 0; i < shipOnMap.size(); i++) {
            if (!shipOnMap.get(i).isFlag()) {
                this.successPickShip = false;
            }
        }
        return shipOnMap;
    }

    /**
     * getShipEdge is create ship border in  coordinatesList;
     * return boolean;
     */
    private Set<Integer> getShipEdge(List<Coordinates> shipOnMap, CoordinatesList coordinatesList) {

        List<Coordinates> shipOnMapRemove = new ArrayList<>(shipOnMap);
        Set<Integer> edgeCoordinatesSet = new HashSet<>();

        for (int i = 0; i < shipOnMap.size(); i++) {
            Coordinates coordinate = shipOnMapRemove.remove(0);
            int x = coordinate.getX();
            int y = coordinate.getY();

            edgeCoordinatesSet.add(coordinatesList.getElement(x, y));
            edgeCoordinatesSet.add(coordinatesList.getElement(x - 1, y));
            edgeCoordinatesSet.add(coordinatesList.getElement(x + 1, y));
            edgeCoordinatesSet.add(coordinatesList.getElement(x + 1, y + 1));
            edgeCoordinatesSet.add(coordinatesList.getElement(x - 1, y - 1));

            edgeCoordinatesSet.add(coordinatesList.getElement(x, y));
            edgeCoordinatesSet.add(coordinatesList.getElement(x, y - 1));
            edgeCoordinatesSet.add(coordinatesList.getElement(x, y + 1));
            edgeCoordinatesSet.add(coordinatesList.getElement(x + 1, y - 1));
            edgeCoordinatesSet.add(coordinatesList.getElement(x - 1, y + 1));
        }
        edgeCoordinatesSet.remove(-1);
        return edgeCoordinatesSet;
    }

    private void setupShip(List<Coordinates> shipOnMap) {
        Iterator<Coordinates> iterator = shipOnMap.iterator();
        while (iterator.hasNext()) {
            iterator.next().setValue("0");
        }
    }

    private void setupEdge(Set<Integer> edgeCoordinatesList, CoordinatesList coordinatesList) {
        Iterator<Integer> iterator = edgeCoordinatesList.iterator();
        while (iterator.hasNext()) {
            Coordinates coordinat = coordinatesList.getList().get(iterator.next());
            coordinat.setFlag(false);
        }
    }

    private int getRandom(int edge) {
        return random.nextInt(edge);
    }
}