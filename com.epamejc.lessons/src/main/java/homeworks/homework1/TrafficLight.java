package homeworks.homework1;

public class TrafficLight {

    public String getColor(int minutes) {
        minutes = getProcessedMinutes(minutes);
        if (minutes >= 6) {
            return Colors.Red + " color";
        } else if (minutes >= 3) {
            return Colors.Yellow + " color";
        } else {
            return Colors.Green + " color";
        }
    }

    private int getProcessedMinutes(int minutes) {
        if (minutes >= 10 || minutes < 0) {
            return Math.abs(minutes % 10);
        }
        return minutes;
    }
}