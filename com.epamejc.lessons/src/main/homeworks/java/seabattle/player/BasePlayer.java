package homeworks.java.seabattle.player;

import homeworks.java.seabattle.battle.Game;
import homeworks.java.seabattle.field.Coordinatepointer;
import homeworks.java.seabattle.field.Field;
import homeworks.java.seabattle.field.ShipFiller;
import homeworks.java.seabattle.field.ship.Deck;
import homeworks.java.seabattle.field.ship.DeckNumberCount;
import homeworks.java.seabattle.field.ship.Ship;
import homeworks.java.seabattle.input.GameState;
import homeworks.java.seabattle.input.InputListener;
import homeworks.java.seabattle.input.Orientation;

import java.util.*;

public class BasePlayer {

    public List<Ship> ships;
    public Field field;

    protected Game game;
    protected Map<DeckNumberCount, Integer> shipCounter;
    protected int maxShips;
    protected int aliveShips;
    protected ShipFiller filler;

    private Coordinatepointer[] neighboursToAttack;
    private Coordinatepointer pointToAttack;
    private Coordinatepointer newPointToAttack;
    private Random random = new Random();
    private static List<Coordinatepointer> listOfAttackedPointsForBot = new ArrayList<>(100);
    private static List<Coordinatepointer> listOfNeighbours = new ArrayList<>();
    private boolean isLucky;
    private InputListener inListener;

    public BasePlayer(Game game) {
        this.game = game;
        this.field = new Field();

        init();
    }

    public Coordinatepointer getNewPointToAttack() {
        return newPointToAttack;
    }

    public void setNewPointToAttack(Coordinatepointer newPointToAttack) {
        this.newPointToAttack = newPointToAttack;
    }

    public boolean isLucky() {
        return isLucky;
    }

    public static List<Coordinatepointer> getListOfAttackedPointsForBot() {
        return listOfAttackedPointsForBot;
    }

    public int getFreePlace(DeckNumberCount dc) {
        return shipCounter.get(dc);
    }

    public final void init() {
        maxShips = 0;
        aliveShips = 0;
        filler = new ShipFiller(this);
        shipCounter = new HashMap<>();
        isLucky = false;
        pointToAttack = new Coordinatepointer(random.nextInt(10), random.nextInt(10));
        neighboursToAttack = new Coordinatepointer[4];
        neighboursToAttack[0] = new Coordinatepointer(-1, 0);
        neighboursToAttack[1] = new Coordinatepointer(0, 1);
        neighboursToAttack[2] = new Coordinatepointer(1, 0);
        neighboursToAttack[3] = new Coordinatepointer(0, -1);

        for (int i = 1; i < DeckNumberCount.decksOnField.length + 1; i++) {

            int shipCount = 5 - i;

            shipCounter.put(DeckNumberCount.valueOf(i), shipCount);
            maxShips += shipCount;
        }
        if (maxShips > 0) {
            ships = new ArrayList<>();
        }
    }

    public void process() {
        field.draw(true);
    }

    public void process(int index, boolean wasLucky, boolean isAlreadyAttackedPoint) {
        if (index == 1 && !isFieldFilled() && game.getState() != GameState.BATTLE) {
            fillAutomatically();
            field.draw(false);
        } else {
            if (isAlreadyAttackedPoint && game.getState() == GameState.BATTLE) {
                doBotAttack(wasLucky);
            } else if (game.getState() == GameState.BATTLE) {
                field.drawBotField();
                doBotAttack(wasLucky);
            }
        }
    }

    private void doBotAttack(boolean wasLucky) {

        while (listOfAttackedPointsForBot.size() != 0 && listOfAttackedPointsForBot.contains(pointToAttack)) {
            pointToAttack = new Coordinatepointer(random.nextInt(10), random.nextInt(10));
        }

        boolean isAttackedPoint = false;
        boolean isMissed = true;

        if (field.isValidCoordinate(pointToAttack) && !listOfAttackedPointsForBot.contains(pointToAttack)) {
            if (!wasLucky) {
                isMissed = checkAttackesPointForEachShip(isMissed);
            } else {
                isMissed = attackNeighbour(false);
            }

            if (isMissed) {
                outputWhenMissed(wasLucky);
                return;
            } else if (isThatTheLastShip()) {
                game.getPlayer().field.draw(true);
                System.out.println("Bot won!");
                inListener.exitGame();
                return;
            } else {
                game.getPlayer().field.draw(true);
                process(1, isLucky(), isAttackedPoint);
            }
        } else {
            if (wasLucky) {
                doBotAttack(wasLucky);
            } else {
                isAttackedPoint = true;
                process(1, isLucky(), isAttackedPoint);
            }
        }
    }

    private boolean attackNeighbour(boolean missed) {
        addNeighbours();

        setNewPointToAttack(listOfNeighbours.get(random.nextInt(listOfNeighbours.size())));

        while (listOfAttackedPointsForBot.contains(newPointToAttack)) {
            setNewPointToAttack(listOfNeighbours.get(random.nextInt(listOfNeighbours.size())));
        }

        if (!listOfAttackedPointsForBot.contains(getNewPointToAttack()) &&
                field.isValidCoordinate(getNewPointToAttack())) {
            for (Ship ship : game.getPlayer().ships) {
                missed = !(checkAttackedPointForEachDeck(ship, getNewPointToAttack()));
                if (!missed) break;
            }
        }
        listOfNeighbours = new ArrayList<>();
        return missed;
    }

    private List<Coordinatepointer> addNeighbours() {
        Coordinatepointer previousPoint = listOfAttackedPointsForBot.get(listOfAttackedPointsForBot.size() - 1);
        for (Coordinatepointer p : neighboursToAttack) {
            Coordinatepointer neighbour = new Coordinatepointer(previousPoint.x + p.x, previousPoint.y + p.y);
            if (field.isValidCoordinate(neighbour)) {
                listOfNeighbours.add(neighbour);
            }
        }
        return listOfNeighbours;
    }

    private void outputWhenMissed(boolean wasLucky) {
        if (wasLucky) {
            listOfAttackedPointsForBot.add(getNewPointToAttack());
            System.out.format("Bot attacked point (%s, %d). Bot missed.\n",
                    field.getHead()[getNewPointToAttack().x], getNewPointToAttack().y + 1);
        } else {
            listOfAttackedPointsForBot.add(pointToAttack);
            System.out.format("Bot attacked point (%s, %d). Bot missed.\n",
                    field.getHead()[pointToAttack.x], pointToAttack.y + 1);
        }
    }

    private boolean checkAttackesPointForEachShip(boolean isMissed) {
        for (Ship ship : game.getPlayer().ships) {
            isMissed = !(checkAttackedPointForEachDeck(ship, pointToAttack));
            if (!isMissed) {
                break;
            }
        }
        return isMissed;
    }

    private boolean checkAttackedPointForEachDeck(Ship ship, Coordinatepointer point) {
        for (Deck deck : ship.getDecks()) {
            if (deck.getPosition().equals(point)) {
                deck.setAlive(false);
                listOfAttackedPointsForBot.add(point);
                printMessageBasedOnIsShipAliveOrDied(ship, point);
                return true;
            }
        }
        isLucky = false;
        return false;
    }

    private boolean isThatTheLastShip() {
        int deadShipCounter = 0;
        for (Ship ship : game.getPlayer().ships) {
            if (ship.isShipAlive() == false) {
                deadShipCounter++;
            }
        }
        if (deadShipCounter == ships.size()) {
            return true;
        }
        return false;
    }

    private void printMessageBasedOnIsShipAliveOrDied(Ship ship, Coordinatepointer point) {
        if (ship.isShipAlive()) {
            System.out.format("Bot attacked point (%s, %d). Bot hit your ship!\n",
                    field.getHead()[point.x], point.y + 1);
            isLucky = true;
        } else {
            System.out.format("Bot attacked point (%s, %d). Bot sank your ship, he'll put 0's around it.\n",
                    field.getHead()[point.x], point.y + 1);
            for (Coordinatepointer coord : ship.getCoordinates()) {
                for (Coordinatepointer p : field.getNeighbours()) {
                    Coordinatepointer neighbour = new Coordinatepointer(coord.x + p.x, coord.y + p.y);
                    if (field.isValidCoordinate(neighbour)) {
                        listOfAttackedPointsForBot.add(neighbour);
                    }
                }
            }
            isLucky = false;
        }
    }

    public boolean isPosibleToPlace(Orientation orient, DeckNumberCount dc, Coordinatepointer startCoord) {
        Coordinatepointer step = orient.getDirection();

        boolean isPossibleToPlace = true;

        Coordinatepointer position = new Coordinatepointer(startCoord.x, startCoord.y);

        for (int i = 0; i < dc.getValue(); i++) {
            isPossibleToPlace = field.isValidCoordinate(position) &&
                    !field.isCollide(position) &&
                    !field.hasNeighbours(position);
            if (!isPossibleToPlace) {
                break;
            }
            position.x = position.x + step.x;
            position.y = position.y + step.y;
        }
        return isPossibleToPlace;
    }

    public boolean addShip(Orientation orient, DeckNumberCount dc, Coordinatepointer startCoord) {
        int freePlaces = getFreePlace(dc);

        if (freePlaces > 0) {
            Coordinatepointer[] coords = Ship.getCoordsForShip(field, dc, orient, startCoord);
            if (coords == null) {
                return false;
            }
            Ship ship = new Ship(field, dc, orient, coords);
            ships.add(ship);
            freePlaces -= 1;
            shipCounter.replace(dc, freePlaces);
            aliveShips++;

            return true;
        }
        return false;
    }

    public boolean isFieldFilled() {
        return maxShips == ships.size();
    }

    public void fillAutomatically() {
        filler.fill();
    }
}
