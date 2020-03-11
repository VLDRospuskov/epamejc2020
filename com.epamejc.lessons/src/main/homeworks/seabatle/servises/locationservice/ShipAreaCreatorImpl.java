package homeworks.seabatle.servises.locationservice;

import java.util.ArrayList;
import java.util.List;

public class ShipAreaCreatorImpl implements ShipAreaCreator {
    /**
     * method creates cross coordinate  area for AI or Field
     *
     * @param target int from 0 to 99
     * @return list of integers
     */
    @Override
    public List<Integer> getCrossArea(Integer target) {
        List<Integer> targetList = new ArrayList<>();
        if (target % 10 != 0) {
            targetList.add(target - 1);
        }
        if (target % 10 != 9) {
            targetList.add(target + 1);
        }
        if (target > 9) {
            targetList.add(target - 10);
        }
        if (target < 90) {
            targetList.add(target + 10);
        }
        return targetList;
    }

    /**
     * method creates diagonal coordinate area for AI or Field
     *
     * @param target int from 0 to 99
     * @return list of integers
     */
    @Override
    public List<Integer> getDiagonalArea(Integer target) {
        List<Integer> targetList = new ArrayList<>();
        if (target % 10 != 0) {
            targetList.add(target - 11);
            if (target < 90) {
                targetList.add(target + 9);
            }

        }
        if (target % 10 != 9) {
            if (target > 9) {
                targetList.add(target - 9);
            }
            if (target < 88) {
                targetList.add(target + 11);
            }

        }
        return targetList;
    }
}
