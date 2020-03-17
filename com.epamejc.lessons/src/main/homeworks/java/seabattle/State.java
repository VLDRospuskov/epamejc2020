package main.homeworks.java.seabattle;

public enum State {
    WATER("~"),
    DECK("D"),
    MISS("0"),
    HIT("X");

    private String visualState;

    State(String x) {
        visualState = x;
    }

    public String toString() {
        return visualState;
    }
}
