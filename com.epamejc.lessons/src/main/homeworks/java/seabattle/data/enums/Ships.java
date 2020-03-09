package homeworks.java.seabattle.data.enums;

public enum Ships {

    CRUISER("Cruiser"),
    DESTROYER("Destroyer"),
    CORVETTE("Corvette"),
    BOAT("Boat");

    private String name;

    Ships(String name) {

        this.name = name;

    }

    public String getName() {

        return name;

    }

}