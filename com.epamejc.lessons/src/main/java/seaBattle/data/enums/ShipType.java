package seaBattle.data.enums;

public enum ShipType {
    LINCOR("lincor"),
    CRUISER("cruiser"),
    DESTROYER("destroyer"),
    BOAT("boat");

    private String type;

    ShipType(String value) {
        this.type = value;
    }

    public String getType() {
        return type;
    }
}
