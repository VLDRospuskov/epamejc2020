package sea_battle.main;

import sea_battle.utils.RandomGenerator;

import java.util.ArrayList;
import java.util.Set;

public class BotPlayer extends Player {

    private boolean isHit;
    private Coordinates fixedCoord;
    private Coordinates lastHit;
    private String selectedDirection;
    private ArrayList<String> checkedDirections;

    public BotPlayer(String title) {
        super(title);
        this.isHit = false;
        this.checkedDirections = new ArrayList<>();

    }

    @Override
    public boolean shot(Player opponent) {
        Coordinates coords;
        Ship ship = getOpponentHitShip();

        if (ship != null && !(ship.isAfloat())) {
            selectedDirection = null;
            fixedCoord = null;
            checkedDirections.clear();
        }

        if (isHit) {
            if (ship.isAfloat() && selectedDirection == null) {
                fixedCoord = getPrevHit();
                lastHit = getPrevHit();
                chooseDirection();
                coords = checkDirection();
            } else if (ship.isAfloat() && selectedDirection != null) {
                coords = checkDirection();
            } else {
                coords = getCoords();
            }
        } else {
            Coordinates prevHit = getPrevHit();
            if (selectedDirection != null && prevHit == null) {
                selectedDirection = changeDirection();
                coords = checkDirection();
            } else {
                coords = getCoords();
            }
        }

        isHit = super.makeShot(opponent, coords.getX(), coords.getY());
        return isHit;
    }

    private String changeDirection() {
        String s = "";

        switch (selectedDirection) {
            case "up" : {
                s = "down";
                if (checkedDirections.contains(s)) {
                    s = "right";
                }
                break;
            }
            case "down" : {
                s = "up";
                if (checkedDirections.contains(s)) {
                    s = "left";
                }
                break;
            }
            case "right" : {
                s = "left";
                if (checkedDirections.contains(s)) {
                    s = "up";
                }
                break;
            }
            case "left" : {
                s = "right";
                if (checkedDirections.contains(s)) {
                    s = "down";
                }
                break;
            }
        }

        checkedDirections.add(s);
        lastHit = fixedCoord;

        return s;
    }

    private void chooseDirection() {
        String[] shootingDirection = new String[] {"up", "down", "left", "right"};
        selectedDirection = shootingDirection[RandomGenerator.generatePoint(shootingDirection.length)];
        checkedDirections.add(selectedDirection);
    }

    private Coordinates checkDirection() {
        Coordinates coord = null;
        switch (selectedDirection) {
            case "up":
                if (lastHit.getY() - 1 < 0) {
                    selectedDirection = "down";
                    lastHit = fixedCoord;
                    return checkDirection();
                }
                coord = new Coordinates(lastHit.getX(), lastHit.getY() - 1);
                break;
            case "down":
                if (lastHit.getY() + 1 > 9) {
                    selectedDirection = "up";
                    lastHit = fixedCoord;
                    return checkDirection();
                }
                coord = new Coordinates(lastHit.getX(), lastHit.getY() + 1);
                break;
            case "right":
                if (lastHit.getX() + 1 > 9) {
                    selectedDirection = "left";
                    lastHit = fixedCoord;
                    return checkDirection();
                }
                coord = new Coordinates(lastHit.getX() + 1, lastHit.getY());
                break;
            case "left":
                if (lastHit.getX() - 1 < 0) {
                    selectedDirection = "right";
                    lastHit = fixedCoord;
                    return checkDirection();
                }
                coord = new Coordinates(lastHit.getX() - 1, lastHit.getY());
                break;
        }

        if (isNotUniqueCoord(getMadeShots(), coord.getX(), coord.getY())) {
            selectedDirection = changeDirection();
            return checkDirection();
        }

        lastHit = coord;
        return coord;
    }

    private Coordinates getCoords() {
        int[] coords;
        Set<Coordinates> madeShots = getMadeShots();

        while (true) {
            coords = RandomGenerator.generateCoordinates();

            if (madeShots.size() > 0) {
                if (isNotUniqueCoord(madeShots, coords[1], coords[0])) {
                    continue;
                }
            }
            break;
        }

        return new Coordinates(coords[1], coords[0]);
    }

    private boolean isNotUniqueCoord(Set<Coordinates> madeShots, int x, int y) {
        for (Coordinates shot : madeShots) {
            if (x == shot.getX() && y == shot.getY()) {
                return true;
            }
        }

        return false;
    }

}
