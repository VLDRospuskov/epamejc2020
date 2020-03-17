package homeworks.newSeabattle.logic;

import homeworks.newSeabattle.data.players.Computer;
import homeworks.newSeabattle.data.players.Player;
import homeworks.newSeabattle.data.players.User;

public class GameGeneration {

    public static Player generateUser() {
        String name = Input.getNameFromUser();
        return new User(name);
    }

    public static Player generateComputer() {
        return new Computer();
    }

    public static void generateField(Player player) {

    }

}
