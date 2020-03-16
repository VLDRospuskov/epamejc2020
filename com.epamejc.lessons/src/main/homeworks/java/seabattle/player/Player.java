package homeworks.java.seabattle.player;

import homeworks.java.seabattle.battle.Game;
import homeworks.java.seabattle.field.Coordinatepointer;
import homeworks.java.seabattle.field.IFieldObject;
import homeworks.java.seabattle.field.ship.Deck;
import homeworks.java.seabattle.field.ship.DeckNumberCount;
import homeworks.java.seabattle.field.ship.Ship;
import homeworks.java.seabattle.input.Input;
import homeworks.java.seabattle.input.InputListener;
import homeworks.java.seabattle.input.Orientation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Player extends BasePlayer implements InputListener {

    private Input input;
    private static List<Coordinatepointer> listOfAttackedPoints = new ArrayList<>();

    public Player(Game game){
        super(game);
        this.input = new Input(this);
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
    public void attack(int x, int y) {
        Coordinatepointer position = new Coordinatepointer(x, y);
//        IFieldObject[][] shipsOfBasePlayer = game.getBasePlayer().field.getObjects();

        if(field.isValidCoordinate(position) && !listOfAttackedPoints.contains(position)){
                for (Ship ship : game.getBasePlayer().ships) {
                    for (Deck deck : ship.getDecks()) {
                        if (deck.getPosition().equals(position)) {
                            deck.setAlive(false);
                            System.out.println(deck.getView());
                            if (ship.isShipAlive()) {
                                System.out.println("Hit!");
                            } else {
                                System.out.println("Sank!");
                            }
                        }
                    }
                }
                process();
        }
        listOfAttackedPoints.add(position);
    }

    @Override
    public boolean makeShip(DeckNumberCount decksNum, Orientation o, Coordinatepointer startCoordinate) {
        System.out.println("Make ship x, y (" + startCoordinate.x + "," + startCoordinate.y + ")");
        addShip(o, decksNum, startCoordinate);
        return getFreePlace(decksNum) > 0;
    }

    @Override
    public void process(){
        super.process();
        input.process(game.getState());
    }

    @Override
    public void process(int index) {
        super.process();
        input.process(game.getState());
    }
}
