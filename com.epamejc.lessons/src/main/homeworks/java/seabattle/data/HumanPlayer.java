package homeworks.java.seabattle.data;

import homeworks.java.seabattle.engine.GameIO;

public class HumanPlayer extends Player {

    public HumanPlayer(String name) {

        super();
        this.setName(name);
        this.setVisible(true);

    }

    @Override
    public Cell shoot() {

        return GameIO.inputCoordinates();

    }

}
