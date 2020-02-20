package homeworks.java.seabattle.enums;

import lombok.Getter;

@Getter
public enum Ships {

    CRUISER(4, 1),
    DESTROYER(3, 2),
    CORVETTE(2, 3),
    FIGHTER(1, 4);

    private int decks;
    private int amount;

    Ships (int decks, int amount) {

        this.decks = decks;
        this.amount = amount;

    }

}
