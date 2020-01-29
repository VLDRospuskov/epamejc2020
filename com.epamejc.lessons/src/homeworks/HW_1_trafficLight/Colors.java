package homeworks.HW_1_trafficLight;

/**
 * These escape codes give colors (green, yellow, red) to the text
 * Final escape code puts everything back, to white output.
 */

public enum Colors {

    GREEN ("\033[1;92m" + "Green. Go on!" + "\u001B[0m"),
    YELLOW ("\033[1;93m" + "Yellow. Finish crossing the street." + "\u001B[0m"),
    RED ("\033[1;91m" + "Red. Stop!" + "\u001B[0m");

    private String message;

    Colors(String title) {
        this.message = title;
    }

    @Override
    public String toString() {
        return message;
    }
}
