package sea_battle.main;

import sea_battle.utils.FieldOperations;
import sea_battle.utils.Reader;
import sea_battle.utils.ShipSetter;

public class Main {

    public static void main(String[] args) {
        FieldOperations operations = new FieldOperations();
        ShipSetter setter = new ShipSetter();
        Reader reader = new Reader();

        Game game = new Game(operations, setter, reader);
        game.run();
    }

}
