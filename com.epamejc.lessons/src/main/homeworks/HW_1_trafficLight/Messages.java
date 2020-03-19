package homeworks.HW_1_trafficLight;

import lombok.AllArgsConstructor;

/**
 * These escape codes color the text (green, yellow, red).
 * Final escape code gets everything back.
 */

@AllArgsConstructor
public enum Messages {

    GREEN("\033[1;92m" + "Green. Go on!" + "\u001B[0m"),
    YELLOW("\033[1;93m" + "Yellow. Finish crossing the street." + "\u001B[0m"),
    RED("\033[1;91m" + "Red. Stop!" + "\u001B[0m");

    private String message;

    @Override
    public String toString() {
        return message;
    }
}
