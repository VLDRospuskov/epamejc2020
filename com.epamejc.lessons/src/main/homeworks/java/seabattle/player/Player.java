package homeworks.java.seabattle.player;

import homeworks.java.seabattle.battle.Game;
import homeworks.java.seabattle.field.Coordinatepointer;
import homeworks.java.seabattle.field.ship.DeckNumberCount;
import homeworks.java.seabattle.input.Input;
import homeworks.java.seabattle.input.InputListener;
import homeworks.java.seabattle.input.Orientation;

public class Player extends BasePlayer implements InputListener {

    private Input input;

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

}
