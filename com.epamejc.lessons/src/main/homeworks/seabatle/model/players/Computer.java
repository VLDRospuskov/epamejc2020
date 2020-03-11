package homeworks.seabatle.model.players;


import homeworks.seabatle.myenum.StrikeResult;
import homeworks.seabatle.servises.locationservice.ShipAreaCreator;
import homeworks.seabatle.servises.locationservice.ShipAreaCreatorImpl;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class Computer extends Player {
    @Getter
    private String name = "Computer";
    private List<Integer> targets;
    private List<Integer> areaTarg;
    @Getter
    @Setter
    private List<Integer> ship;
    private boolean isWounded = false;
    @Setter
    private Integer currentTarget;
    private ShipAreaCreator creator;
    private Random r;

    public Computer() {
        r = new Random();
        targets = getTargets();
        ship = new ArrayList<>();
        creator = new ShipAreaCreatorImpl();
    }

    /**
     * method updates the situation for AI,
     * it help him to understand, what method he should use for
     * shooting. There are 3 variants: Random, Area, Lane.
     * If ship is wounded and there is one hit on him, AI shoots on area,
     * if ship is wounded and there three hits on him, AI shoots on Lane,
     * else AI shoots on Random
     *
     * @param result enum, contains the information about last strike
     */
    public void notifyShootResult(StrikeResult result) {
        switch (result) {
            case KILL:
                isWounded = false;
                updateAfterKill();
                break;
            case WOUND:
                isWounded = true;
                updateAfterWound();
                break;
            case MISS:
                updateTargets(currentTarget);
                break;
        }
    }

    /**
     * method that choose the strategy of shooting depends on condition
     * after notifying
     *
     * @return integer from 0 to 99
     */
    public Integer shoot() {
        Integer coordinate;
        if (isWounded) {
            coordinate = getTargetedInt();
        } else {
            coordinate = getRandomInt();
        }
        setCurrentTarget(coordinate);
        if (targets.contains(coordinate)) {
            return coordinate;
        } else return shoot();

    }

    /**
     * method updates logic after ship was killed
     */
    private void updateAfterKill() {
        addToShip();
        updateTargets(currentTarget);
        clearShipArea();
        clearShip();
    }

    /**
     * method updates logic after ship was wounded
     */
    private void updateAfterWound() {
        updateTargets(currentTarget);
        areaTarg = makeArea(currentTarget);
        addToShip();
    }

    /**
     * @return random int, containing in targets array
     */
    private int getRandomInt() {
        int index = r.nextInt(targets.size());
        return targets.get(index);
    }

    /**
     * method choose between lane and area strategy
     *
     * @return int from 0 to 99
     */
    private int getTargetedInt() {
        if (ship.size() == 1) {
            return makeAreaShoot();
        } else {
            return makeLineShoot();
        }
    }

    /**
     * method choose where to strike after any ship was wounded
     *
     * @return int from 0 to 99
     */
    private int makeAreaShoot() {
        int index = r.nextInt(areaTarg.size());
        Integer target = areaTarg.get(index);
        areaTarg.remove(index);
        return target;


    }

    /**
     * method choose where to strike after any ship was wounded twice or more
     *
     * @return int from 0 to 99
     */
    private int makeLineShoot() {
        Collections.sort(ship);
        int step = ship.get(1) - ship.get(0);
        int choose = r.nextInt(2);
        int target;
        if (choose == 0) {
            target = ship.get(0) - step;
        } else {
            target = ship.get(ship.size() - 1) + step;
        }
        if (targets.contains(target)) {
            return target;
        } else {
            return makeLineShoot();
        }
    }

    /**
     * method creates cross area for area shoot
     *
     * @param target coordinate of the last strike, that wounded ship for the first time
     * @return
     */
    private List<Integer> makeArea(int target) {
        List<Integer> area = creator.getCrossArea(target);

        return area;
    }

    /**
     * method updates condition of targets after strike
     *
     * @param target coordinate of the last strike
     */
    private void updateTargets(Integer target) {
        targets.remove(target);
    }

    /**
     * if ship is killed this method creates a list of all coords near him and send them to
     * another method because we need to clean them from targets
     */
    private void clearShipArea() {
        List<Integer> tempCoordinates = new ArrayList<>();
        for (int coord : ship) {
            tempCoordinates.addAll(creator.getCrossArea(coord));
            tempCoordinates.addAll(creator.getDiagonalArea(coord));
        }
        targets.removeAll(tempCoordinates);
    }


    /**
     * make List of ship coordinates for Lane shot
     */
    private void addToShip() {
        ship.add(currentTarget);
    }

    /**
     * clear List of ship coordinates for Lane shot
     */
    private void clearShip() {
        ship.clear();
    }

    /**
     * @return List of targets for AI (integers from 0 to 99)
     */
    private List<Integer> getTargets() {
        List<Integer> targets = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            targets.add(i);
        }
        return targets;
    }

}
