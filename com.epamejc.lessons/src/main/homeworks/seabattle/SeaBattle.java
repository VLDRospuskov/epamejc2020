package homeworks.seabattle;

import java.awt.*;

public class SeaBattle {

    public static int score;
    public final int TOTAL_SCORE = 20;
    private GameField field = new GameField();
    private Game game = new Game();

    public void run() {
        while (score < TOTAL_SCORE) {
            field.show();
            Point p = game.getPointFromUser();
            field.update(p);
        }

        field.show();
        System.out.println("You won the game!");
    }

}
