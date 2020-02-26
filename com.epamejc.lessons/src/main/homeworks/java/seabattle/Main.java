package homeworks.java.seabattle;

import homeworks.java.seabattle.engine.Seabattle;
import homeworks.java.utils.UserInputReader;

public class Main {

    public static void main(String[] args) {

    Seabattle seabattle = new Seabattle();
    seabattle.run();
    UserInputReader.close();

    }

}
