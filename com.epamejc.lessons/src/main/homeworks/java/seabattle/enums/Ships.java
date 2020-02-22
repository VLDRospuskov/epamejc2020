package homeworks.java.seabattle.enums;

public enum Ships {

    CRUISER(1, 4),
    DESTROYER(2, 3),
    CORVETTE(3, 2),
    FIGHTER(4, 1);

    private int count;
    private int length;

    Ships(int count, int length) {

        this.count = count;
        this.length = length;

    }

    public int getCount() {

        return count;

    }

    public int getLength() {

        return length;

    }

}