package homeworks.java.seabattle.field.ship;

public enum DeckNumberCount {

    INVALIDE(-1),
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4);

    private int value;
    private static DeckNumberCount[] field;

    static {
        field = new DeckNumberCount[5];

        int counter = 0;

        for (DeckNumberCount d : DeckNumberCount.values()) {
            field[counter++] = d;
        }
    }

    DeckNumberCount(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static DeckNumberCount valueOf(int i) {
        if (i >= 0 && i < 5) {
            return field[i];
        }
        return INVALIDE;
    }
}
