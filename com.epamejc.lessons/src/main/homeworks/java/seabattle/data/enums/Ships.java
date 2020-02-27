package homeworks.java.seabattle.data.enums;

public enum Ships {

    CRUISER(1, 4, "Cruiser"),
    DESTROYER(2, 3, "Destroyer"),
    CORVETTE(3, 2, "Corvette"),
    FIGHTER(4, 1, "Fighter");

    private int count;
    private int length;
    private String name;

    Ships(int count, int length, String name) {

        this.count = count;
        this.length = length;
        this.name = name;

    }

    public int getCount() {

        return count;

    }

    public int getLength() {

        return length;

    }

    public String getName() {

        return name;

    }

}