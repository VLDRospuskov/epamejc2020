package homeworks.java.seabattle;

import homeworks.java.seabattle.engine.SeaBattle;
import homeworks.java.utils.UserInputReader;

public class Main {

    public static void main(String[] args) {

        SeaBattle seabattle = new SeaBattle();
        seabattle.run();
        UserInputReader.close();

    }

}
