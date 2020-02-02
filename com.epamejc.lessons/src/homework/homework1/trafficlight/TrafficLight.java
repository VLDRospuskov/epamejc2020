package homework.homework1.trafficlight;

public class TrafficLight {
    TrafficLightColor lightColor = TrafficLightColor.RED;

    public void setColor(int color) throws IllegalArgumentException {
        if (color < 0 || color > 10)
            throw new IllegalArgumentException("An integer value between 0 and 10 is required!");
        if (color <= 3) {
            lightColor = TrafficLightColor.GREEN;
        } else if (color <= 5) {
            lightColor = TrafficLightColor.YELLOW;
        } else {
            lightColor = TrafficLightColor.RED;
        }
    }

    public String getColor() {
        return lightColor.name();
    }
}