package homeworks.seabatle.servises.locationservice;

import java.util.List;

public interface ShipAreaCreator {
    List<Integer> getCrossArea(Integer target);

    List<Integer> getDiagonalArea(Integer target);
}
