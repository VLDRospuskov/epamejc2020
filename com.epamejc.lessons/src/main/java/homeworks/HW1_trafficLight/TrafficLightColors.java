package homeworks.HW1_trafficLight;

public enum TrafficLightColors {
    GREEN("Green light"),
    YELLOW("Yellow light"),
    RED("Red light"),
    enterStringMessage("Type \"-1\" to exit or enter the number of seconds: "),
    appFinishMessage("Program ends. Goodbye."),
    incorrectInputMessage("Traffic light isn't working yet");

    private String message;

    TrafficLightColors(String value) {
        this.message = value;
    }

    public String getMessage() {
        return message;
    }
}
