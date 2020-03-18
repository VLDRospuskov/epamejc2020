package homeworks.SeaBattle.data.enums;

public enum Chars {

    SHIP('S'),
    MISS('·'),
    HIT('/'),
    DESTROYED('X'),
    EMPTY(' ');

    private char ch;

    Chars(char s) {
        this.ch = s;
    }

    public char getChar() {
        return ch;
    }

}
