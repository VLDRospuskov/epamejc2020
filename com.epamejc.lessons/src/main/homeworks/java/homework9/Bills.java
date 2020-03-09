package main.homeworks.java.homework9;

public enum Bills {
    TEN(10),
    FIFTY(50),
    ONEHUNDRED(100),
    TWOHUNDRED(200),
    FIVEHUNDRED(500),
    THOUSAND(1000),
    FIVETHOUSAND(5000);

    private final int value;

    Bills(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
