package homeworks.java.seabattle.enums;

public enum Actor {

    HUMAN ("Player"),
    COMPUTER ("Computer");

    private String name;

    Actor (String name) {

        this.name = name;

    }

    public String getName() {

        return name;

    }

}
