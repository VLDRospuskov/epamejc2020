package sea_battle.enums;

public enum ShipTypes {
    SINGLE_DECK(1), DOUBLE_DECK(2), TRIPLE_DECK(3), QUADRUPLE_DECK(4);

    private int value;

    ShipTypes(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
