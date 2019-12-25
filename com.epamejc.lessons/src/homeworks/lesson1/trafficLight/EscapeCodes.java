package homeworks.lesson1.trafficLight;

public enum EscapeCodes {

    RESET ("\u001B[0m"),
    RED ("\033[1;91m"),
    GREEN ("\033[1;92m"),
    YELLOW ("\033[1;93m");

    private String code;

    EscapeCodes(String title) {
        this.code = title;
    }

    @Override
    public String toString() {
        return code;
    }
}
