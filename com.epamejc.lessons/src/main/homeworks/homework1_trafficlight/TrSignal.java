package homeworks.homework1_trafficlight;

public enum TrSignal {
    RED,YEllOW,GREEN;

    @Override
    public String toString() {
        String id = name();
        String lower = id.substring(1).toLowerCase();
        return "The traffic light is: " + id.charAt(0) + lower;
    }
}