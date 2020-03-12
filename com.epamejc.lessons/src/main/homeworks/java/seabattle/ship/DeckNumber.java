package homeworks.java.seabattle.ship;

public enum DeckNumber {

    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4);

    private int value;

    DeckNumber(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
