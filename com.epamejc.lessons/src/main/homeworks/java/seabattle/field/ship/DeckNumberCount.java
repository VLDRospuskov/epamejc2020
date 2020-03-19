package homeworks.java.seabattle.field.ship;

public enum DeckNumberCount {

    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    INVALID(-1);

    private int value;
    public static DeckNumberCount[] decksOnField;

    static {
        decksOnField = new DeckNumberCount[4];

        int counter = 0;

        for (DeckNumberCount d : DeckNumberCount.values()) {
            if (d.getValue() > 0) {
                decksOnField[counter++] = d;
            }
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
            return decksOnField[i - 1];
        }
        return INVALID;
    }

}
