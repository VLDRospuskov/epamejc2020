package homeworks.seabattle.player;

import homeworks.seabattle.field.Ship;

import java.util.*;

public class AI extends Player {

    private ArrayList<Character> letters = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'k', 'l', 'm', 'n'));

    @Override
    public AbstractMap.SimpleEntry<Character, Integer> handleCoordinatesInput() {
        Character letter;
        Random random = new Random();
        letter = letters.get(random.nextInt(field.size));

        Integer number;
        number = random.nextInt(field.size);

        return new AbstractMap.SimpleEntry<>(letter, number);
    }

    @Override
    public Ship handleShipPlacement(int length) {
        Character letter;
        Random random = new Random();
        letter = letters.get(random.nextInt(field.size));

        Integer number;
        number = random.nextInt(field.size);

        int direction;
        direction = random.nextInt(2);
        return super.handleShipPlacement(length);
    }

    @Override
    public void move() {

    }
}
