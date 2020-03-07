package homeworks.seabatle;

import homeworks.seabatle.aplication.Game;


public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Thread thread = new Thread(game);
        thread.start();
    }
}
