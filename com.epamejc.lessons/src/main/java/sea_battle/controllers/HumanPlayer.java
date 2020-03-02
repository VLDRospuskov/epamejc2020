package sea_battle.controllers;

import sea_battle.utils.Points;
import sea_battle.utils.Reader;

public class HumanPlayer extends Player {

    private Reader reader;

    public HumanPlayer(Reader reader, String title) {
        super(title);
        this.reader = reader;
    }

    @Override
    public boolean shot(Player opponent) {
        String userInput = reader.read();
        int[] coords = parseUserInput(userInput);
        int x = coords[1];
        int y = coords[0];

        if (x < 0 || x > 9 && y < 0 || y > 9) {
            shot(opponent);
        }

        return super.makeShot(opponent, x, y);
    }

    private int[] parseUserInput(String userInput) {
        String letter = userInput.substring(0, 1).toUpperCase();
        int x = Points.valueOf(letter).ordinal();
        int y = Integer.parseInt(userInput.substring(1)) - 1;

        return new int[] {y, x};
    }
}
