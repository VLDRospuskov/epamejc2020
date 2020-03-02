package sea_battle.main;

import sea_battle.utils.Reader;

public class Main {

    public static void main(String[] args) {
        ShipSetter setter = new ShipSetter();
        Reader reader = new Reader();

        Game game = new Game(setter, reader);
        game.run();
    }

}
