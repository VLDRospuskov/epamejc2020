package sea_battle.utils;

public enum ShipTypes {
    SINGLE_DECK(1), DOUBLE_DECK(2), THREE_DECK(3), FOUR_DECK(4);

    private int value;

    ShipTypes(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
