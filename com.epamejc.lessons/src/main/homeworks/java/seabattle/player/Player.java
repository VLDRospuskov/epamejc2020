package homeworks.java.seabattle.player;

import homeworks.java.seabattle.battle.Game;
import homeworks.java.seabattle.field.Coordinatepointer;
import homeworks.java.seabattle.field.ship.Deck;
import homeworks.java.seabattle.field.ship.DeckNumberCount;
import homeworks.java.seabattle.field.ship.Ship;
import homeworks.java.seabattle.input.Input;
import homeworks.java.seabattle.input.InputListener;
import homeworks.java.seabattle.input.Orientation;

import java.util.ArrayList;
import java.util.List;

public class Player extends BasePlayer implements InputListener {

    private Input input;
    private static List<Coordinatepointer> listOfAttackedPoints = new ArrayList<>(100);

    public Player(Game game) {
        super(game);
        this.input = new Input(this);
    }

    public static List<Coordinatepointer> getListOfAttackedPoints() {
        return listOfAttackedPoints;
    }

    @Override
    public void exitGame() {
        game.setGameOverTrue();
    }

    @Override
    public void fillAutomatically() {
        filler.fill();
    }

    @Override
    public boolean makeShip(DeckNumberCount decksNum, Orientation o, Coordinatepointer startCoordinate) {
        System.out.println("Make ship x, y (" + startCoordinate.x + "," + startCoordinate.y + ")");
        addShip(o, decksNum, startCoordinate);
        return getFreePlace(decksNum) > 0;
    }

    @Override
    public void process() {
        super.process();
        input.humanPlayerProcess(game.getState());
    }

    @Override
    public void process(int index, boolean wasLastAttackLucky, boolean isAttackedPoint) {
        super.process();
        input.humanPlayerProcess(game.getState());
    }

    @Override
    public void attack(int x, int y) {
        Coordinatepointer position = new Coordinatepointer(x, y);
//        IFieldObject[][] shipsOfBasePlayer = game.getBasePlayer().field.getObjects();

        if (field.isValidCoordinate(position) && !listOfAttackedPoints.contains(position)) {
            boolean isMissed = true;

            for (Ship ship : game.getBasePlayer().ships) {
                isMissed = !(checkIfAttackedPointIsAnEnemyShipPoint(ship, position));
                if (!isMissed) break;
            }

            if(isMissed){
                listOfAttackedPoints.add(position);
                System.out.println("You missed! :P");
                return;
            } else if(isThatTheLastShip()) {
                game.getBasePlayer().field.drawBotField();
                System.out.println("Congratulations! You won!");
                exitGame();
                return;
            } else {
                game.getBasePlayer().field.drawBotField();
                process();
            }
        } else {
            System.out.println("You already attacked this position/Some problems with the coordinate validation");
            game.getBasePlayer().field.drawBotField();
            process();
        }
    }

    private boolean checkIfAttackedPointIsAnEnemyShipPoint(Ship ship, Coordinatepointer attackedPoint) {
        for (Deck deck : ship.getDecks()) {
            if (deck.getPosition().equals(attackedPoint)) {
                deck.setAlive(false);
                listOfAttackedPoints.add(attackedPoint);
                printMessageBasedOnIsShipAliveOrDied(ship);
                return true;
            }
        }
        return false;
    }

    private boolean isThatTheLastShip() {
        int deadShipCounter = 0;
        for(Ship ship : game.getBasePlayer().ships){
            if(ship.isShipAlive() == false){
                deadShipCounter++;
            }
        }
        if(deadShipCounter == ships.size()){
            return true;
        }
        return false;
    }

    private void printMessageBasedOnIsShipAliveOrDied(Ship ship) {
        if (ship.isShipAlive()) {
            System.out.println("Hit!");
        } else {
            System.out.println("Sank!");
        }
    }
}
