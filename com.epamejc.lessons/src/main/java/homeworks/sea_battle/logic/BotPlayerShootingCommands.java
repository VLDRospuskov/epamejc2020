package homeworks.sea_battle.logic;

import homeworks.sea_battle.commands.PlayerShootingCommands;
import homeworks.sea_battle.data.Coordinates;
import homeworks.sea_battle.data.Player;
import homeworks.sea_battle.utils.RandomGenerator;

import java.util.ArrayList;
import java.util.Set;

public class BotPlayerShootingCommands implements PlayerShootingCommands {

    private String selectedDirection;
    private boolean isHit;
    private Coordinates fixedCoord;
    private Coordinates lastHit;
    private ArrayList<String> shootingDirections;

    public BotPlayerShootingCommands() {
        this.shootingDirections = new ArrayList<>();
        initShootingDirections();
    }

    @Override
    public boolean shot(Player player, Player opponent) {
        System.out.println(opponent.getName() + " field");
        PrintFieldCommand.printField(player.getOpponentField().getField());

        System.out.print(player.getName() + " turn: ");

        Coordinates coords = getCoordinates(player);

        if (isHit = makeShot(player, opponent, coords.getX(), coords.getY())) {
            lastHit = coords;
        } else {
            lastHit = null;
        }

        return isHit;
    }

    private Coordinates getCoordinates(Player player) {
        Coordinates coords;

        if (isHit) {
            if (player.getLastHitShip().isAfloat() && selectedDirection == null) {
                fixedCoord = lastHit;
                chooseDirection();
                coords = getCoordinatesInTheDirection(player.getMadeShots());
            } else if (player.getLastHitShip().isAfloat() && selectedDirection != null) {
                coords = getCoordinatesInTheDirection(player.getMadeShots());
            } else {
                selectedDirection = null;
                fixedCoord = null;
                lastHit = null;
                initShootingDirections();
                coords = getRandomCoordinates(player.getMadeShots());
            }
        } else {
            if (selectedDirection != null & lastHit == null) {
                lastHit = fixedCoord;
                chooseDirection();
                coords = getCoordinatesInTheDirection(player.getMadeShots());
            } else {
                coords = getRandomCoordinates(player.getMadeShots());
            }
        }
        return coords;
    }

    private Coordinates getCoordinatesInTheDirection(Set<Coordinates> madeShots) {
        Coordinates coordinates = null;

        switch (selectedDirection) {
            case "up":
                if (lastHit.getY() - 1 < 0) {
                    selectedDirection = "down";
                    lastHit = fixedCoord;
                    return getCoordinatesInTheDirection(madeShots);
                }
                coordinates = new Coordinates(lastHit.getX(), lastHit.getY() - 1);
                break;
            case "down":
                if (lastHit.getY() + 1 > 9) {
                    selectedDirection = "up";
                    lastHit = fixedCoord;
                    return getCoordinatesInTheDirection(madeShots);
                }
                coordinates = new Coordinates(lastHit.getX(), lastHit.getY() + 1);
                break;
            case "right":
                if (lastHit.getX() + 1 > 9) {
                    selectedDirection = "left";
                    lastHit = fixedCoord;
                    return getCoordinatesInTheDirection(madeShots);
                }
                coordinates = new Coordinates(lastHit.getX() + 1, lastHit.getY());
                break;
            case "left":
                if (lastHit.getX() - 1 < 0) {
                    selectedDirection = "right";
                    lastHit = fixedCoord;
                    return getCoordinatesInTheDirection(madeShots);
                }
                coordinates = new Coordinates(lastHit.getX() - 1, lastHit.getY());
                break;
        }

        if (isNotUniqueCoord(madeShots, coordinates.getX(), coordinates.getY())) {
            chooseDirection();
            coordinates = getCoordinatesInTheDirection(madeShots);
        }

        return coordinates;
    }

    private void initShootingDirections() {
        shootingDirections.clear();
        shootingDirections.add("up");
        shootingDirections.add("down");
        shootingDirections.add("left");
        shootingDirections.add("right");

    }

    private void chooseDirection() {
        selectedDirection = shootingDirections.get(RandomGenerator.generatePoint(shootingDirections.size()));
        shootingDirections.remove(selectedDirection);
    }

    private Coordinates getRandomCoordinates(Set<Coordinates> madeShots) {
        Coordinates coords;

        while (true) {
            coords = RandomGenerator.generateCoordinates();

            if (madeShots.size() > 0) {
                if (isNotUniqueCoord(madeShots, coords.getX(), coords.getY())) {
                    continue;
                }
            }
            break;
        }

        return new Coordinates(coords.getX(), coords.getY());
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
