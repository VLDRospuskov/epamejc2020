package homeworks.homework1;

public class Application {
    public static void main(String[] args) {
        IOConsoleProvider ioConsoleProvider = new IOConsoleProvider();
        TheTrafficLights lights = new TheTrafficLights(ioConsoleProvider);

        lights.run();
    }
}
